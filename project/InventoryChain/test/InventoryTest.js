const Inventory = artifacts.require("Inventory");

contract("Inventory", (accounts) => {
    it("should store a new transaction", async () => {
        const instance = await Inventory.deployed();
        const txId = 999;
        const productName = "WidgetA";
        const txType = "IN";
        const qty = 100;
        const supplierName = "ABC Supplies";

        let txReceipt = await instance.storeTransaction(
            txId,
            productName,
            txType,
            qty,
            supplierName,
            { from: accounts[0] }
        );

        // Check that an event was emitted
        const event = txReceipt.logs[0];
        assert.equal(event.event, "TransactionStored", "Event should be TransactionStored");
        assert.equal(event.args.transactionId, txId, "TransactionID should match");
        assert.equal(event.args.productName, productName, "ProductName should match");
        assert.equal(event.args.quantity.toNumber(), qty, "Quantity should match");
    });
});
