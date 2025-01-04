//package org.example.demo1;
//import org.web3j.protocol.Web3j;
//import org.web3j.protocol.http.HttpService;
//import org.web3j.tx.gas.DefaultGasProvider;
//import org.web3j.crypto.Credentials;
//import org.example.demo1.InventoryTransactions;
//
//import java.math.BigInteger;
//
//public class BlockchainService {
//    private static final String GANACHE_URL = "http://127.0.0.1:7545";
//    private static final String PRIVATE_KEY = "0x1ea9dfcb601afcd9e463c71bcb9d609ef71efca15e1622ec27145303bd7f156d";
//    private static final String CONTRACT_ADDRESS = "0x295CB5327d2aBaE76D793AD537186C573fA6564E";
//
//    private Web3j web3j;
//    private InventoryTransactions contract;
//
//    public BlockchainService() throws Exception {
//        // Connect to Ganache
//        web3j = Web3j.build(new HttpService(GANACHE_URL));
//        System.out.println("Connected to Ganache: " + web3j.web3ClientVersion().send().getWeb3ClientVersion());
//
//        // Load credentials
//        Credentials credentials = Credentials.create(PRIVATE_KEY);
//
//        // Load the smart contract
//        contract = InventoryTransactions.load(CONTRACT_ADDRESS, web3j, credentials, new DefaultGasProvider());
//    }
//
//    public void logTransaction(String itemName, int quantity, String transactionType) throws Exception {
//        // Interact with the smart contract
//        contract.logTransaction(itemName, BigInteger.valueOf(quantity), transactionType).send();
//        System.out.println("Transaction logged successfully on the blockchain!");
//    }
//}
