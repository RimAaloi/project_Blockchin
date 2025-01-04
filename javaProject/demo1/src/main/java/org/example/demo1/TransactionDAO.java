package org.example.demo1;

//package com.example.inventory;

import java.sql.*;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;


public class TransactionDAO {

    public static void insertTransaction(Transaction transaction) {
        String sql = "INSERT INTO transactions (product_id, transaction_type, quantity, remarks) "
                + "VALUES (?, ?, ?, ?)";

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, transaction.getProductId());
            pstmt.setString(2, transaction.getTransactionType());
            pstmt.setInt(3, transaction.getQuantity());
            pstmt.setString(4, transaction.getRemarks());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<TransactionView> getAllTransactionViews() {
        List<TransactionView> list = new ArrayList<>();
        String sql = "SELECT t.transaction_id, p.product_name, t.transaction_type, t.quantity, "
                + "       t.transaction_date, s.supplier_name "
                + "  FROM transactions t "
                + "  JOIN products p ON t.product_id = p.product_id "
                + "  JOIN suppliers s ON p.supplier_id = s.supplier_id "
                + " ORDER BY t.transaction_date DESC";

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                int tid = rs.getInt("transaction_id");
                String productName = rs.getString("product_name");
                String txType = rs.getString("transaction_type");
                int qty = rs.getInt("quantity");
                Timestamp txDate = rs.getTimestamp("transaction_date");
                String supplierName = rs.getString("supplier_name");

                // Convert SQL Timestamp to LocalDateTime
                LocalDateTime localTxDate = txDate.toInstant()
                        .atZone(ZoneId.systemDefault())
                        .toLocalDateTime();

                TransactionView tv = new TransactionView(
                        tid, productName, txType, qty, supplierName, localTxDate
                );
                list.add(tv);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }
}
