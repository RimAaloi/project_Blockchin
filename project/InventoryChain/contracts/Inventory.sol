// SPDX-License-Identifier: MIT
pragma solidity ^0.8.21;

contract Inventory {
    struct TxRecord {
        uint256 transactionId; // optional or auto
        string productName;
        string transactionType; // "IN" or "OUT"
        uint256 quantity;
        string supplierName;
        uint256 timestamp; // block timestamp
    }

    TxRecord[] public transactions;

    event TransactionStored(
        uint256 indexed transactionId,
        string productName,
        string transactionType,
        uint256 quantity,
        string supplierName,
        uint256 timestamp
    );

    function storeTransaction(
        uint256 _transactionId,
        string memory _productName,
        string memory _transactionType,
        uint256 _quantity,
        string memory _supplierName
    ) public {
        TxRecord memory newTx = TxRecord({
            transactionId: _transactionId,
            productName: _productName,
            transactionType: _transactionType,
            quantity: _quantity,
            supplierName: _supplierName,
            timestamp: block.timestamp
        });

        transactions.push(newTx);

        emit TransactionStored(
            _transactionId,
            _productName,
            _transactionType,
            _quantity,
            _supplierName,
            block.timestamp
        );
    }

    // Optionally: function getTransactionCount() public view returns (uint256) {
    //     return transactions.length;
    // }

    // Optionally: function getTransaction(uint256 index) public view returns (TxRecord memory) {
    //     return transactions[index];
    // }
}
