package org.example.demo1;

//package com.example.inventory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {

    public static List<Product> getAllProducts() {
        List<Product> productList = new ArrayList<>();
        String sql = "SELECT * FROM products";

        try (Connection conn = DBUtil.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Product p = new Product(
                        rs.getInt("product_id"),
                        rs.getString("product_name"),
                        rs.getString("description"),
                        rs.getInt("category_id"),
                        rs.getInt("supplier_id"),
                        rs.getDouble("cost_price"),
                        rs.getDouble("selling_price"),
                        rs.getInt("reorder_level"),
                        rs.getInt("current_stock")
                );
                productList.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productList;
    }

    public static void insertProduct(Product product) {
        String sql = "INSERT INTO products (product_name, description, category_id, supplier_id, "
                + "cost_price, selling_price, reorder_level, current_stock) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, product.getProductName());
            pstmt.setString(2, product.getDescription());
            pstmt.setInt(3, product.getCategoryId());
            pstmt.setInt(4, product.getSupplierId());
            pstmt.setDouble(5, product.getCostPrice());
            pstmt.setDouble(6, product.getSellingPrice());
            pstmt.setInt(7, product.getReorderLevel());
            pstmt.setInt(8, product.getCurrentStock());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updateProduct(Product product) {
        String sql = "UPDATE products SET product_name=?, description=?, category_id=?, "
                + "supplier_id=?, cost_price=?, selling_price=?, reorder_level=?, current_stock=? "
                + "WHERE product_id=?";

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, product.getProductName());
            pstmt.setString(2, product.getDescription());
            pstmt.setInt(3, product.getCategoryId());
            pstmt.setInt(4, product.getSupplierId());
            pstmt.setDouble(5, product.getCostPrice());
            pstmt.setDouble(6, product.getSellingPrice());
            pstmt.setInt(7, product.getReorderLevel());
            pstmt.setInt(8, product.getCurrentStock());
            pstmt.setInt(9, product.getProductId());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deleteProduct(int productId) {
        String sql = "DELETE FROM products WHERE product_id=?";

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, productId);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<Product> getLowStockProducts() {
        List<Product> lowStockList = new ArrayList<>();
        String sql = "SELECT * FROM products WHERE current_stock <= reorder_level";

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                Product p = new Product(
                        rs.getInt("product_id"),
                        rs.getString("product_name"),
                        rs.getString("description"),
                        rs.getInt("category_id"),
                        rs.getInt("supplier_id"),
                        rs.getDouble("cost_price"),
                        rs.getDouble("selling_price"),
                        rs.getInt("reorder_level"),
                        rs.getInt("current_stock")
                );
                lowStockList.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lowStockList;
    }
}
