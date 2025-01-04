package org.example.demo1;

//package com.example.inventory;

import java.time.LocalDateTime;

public class TransactionView {
    private int transactionId;
    private String productName;
    private String transactionType; // "IN" or "OUT"
    private int quantity;
    private String supplierName;
    private LocalDateTime transactionDate;

    public TransactionView(int transactionId, String productName, String transactionType,
                           int quantity, String supplierName, LocalDateTime transactionDate) {
        this.transactionId = transactionId;
        this.productName = productName;
        this.transactionType = transactionType;
        this.quantity = quantity;
        this.supplierName = supplierName;
        this.transactionDate = transactionDate;
    }

    // Getters and setters...
    public int getTransactionId() { return transactionId; }
    public void setTransactionId(int transactionId) { this.transactionId = transactionId; }

    public String getProductName() { return productName; }
    public void setProductName(String productName) { this.productName = productName; }

    public String getTransactionType() { return transactionType; }
    public void setTransactionType(String transactionType) { this.transactionType = transactionType; }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    public String getSupplierName() { return supplierName; }
    public void setSupplierName(String supplierName) { this.supplierName = supplierName; }

    public LocalDateTime getTransactionDate() { return transactionDate; }
    public void setTransactionDate(LocalDateTime transactionDate) { this.transactionDate = transactionDate; }
}
