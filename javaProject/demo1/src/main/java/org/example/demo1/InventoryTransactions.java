//package org.example.demo1;
//
//import io.reactivex.Flowable;
//import java.math.BigInteger;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Collections;
//import java.util.HashMap;
//import java.util.List;
//import java.util.concurrent.Callable;
//import org.web3j.abi.EventEncoder;
//import org.web3j.abi.TypeReference;
//import org.web3j.abi.datatypes.Event;
//import org.web3j.abi.datatypes.Function;
//import org.web3j.abi.datatypes.Type;
//import org.web3j.abi.datatypes.Utf8String;
//import org.web3j.abi.datatypes.generated.Uint256;
//import org.web3j.crypto.Credentials;
//import org.web3j.protocol.Web3j;
//import org.web3j.protocol.core.DefaultBlockParameter;
//import org.web3j.protocol.core.RemoteCall;
//import org.web3j.protocol.core.RemoteFunctionCall;
//import org.web3j.protocol.core.methods.request.EthFilter;
//import org.web3j.protocol.core.methods.response.BaseEventResponse;
//import org.web3j.protocol.core.methods.response.Log;
//import org.web3j.protocol.core.methods.response.TransactionReceipt;
//import org.web3j.tuples.generated.Tuple4;
//import org.web3j.tx.Contract;
//import org.web3j.tx.TransactionManager;
//import org.web3j.tx.gas.ContractGasProvider;
//
///**
// * <p>Auto generated code.
// * <p><strong>Do not modify!</strong>
// * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
// * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the
// * <a href="https://github.com/hyperledger/web3j/tree/main/codegen">codegen module</a> to update.
// *
// * <p>Generated with web3j version 1.6.1.
// */
//@SuppressWarnings("rawtypes")
//public class InventoryTransactions extends Contract {
//    public static final String BINARY = "0x6080604052348015600e575f5ffd5b506105a98061001c5f395ff3fe608060405234801561000f575f5ffd5b506004361061003f575f3560e01c80632e7700f01461004357806370894ee6146100585780639ace38c21461006d575b5f5ffd5b5f546040519081526020015b60405180910390f35b61006b610066366004610346565b610090565b005b61008061007b3660046103b3565b610161565b60405161004f94939291906103f8565b60408051608081018252848152602081018490529081018290524260608201525f8054600181018255908052815182916004027f290decd9548b62a8d60345a988386fc84ba6bc95484008f6362f93160ef3e563019081906100f290826104b8565b50602082015160018201556040820151600282019061011190826104b8565b506060820151816003015550507f0ac91df60dbfb362ebbb40967738ed984516ab607bd78b949a2f32f07de1b6878484844260405161015394939291906103f8565b60405180910390a150505050565b5f818154811061016f575f80fd5b905f5260205f2090600402015f91509050805f01805461018e90610434565b80601f01602080910402602001604051908101604052809291908181526020018280546101ba90610434565b80156102055780601f106101dc57610100808354040283529160200191610205565b820191905f5260205f20905b8154815290600101906020018083116101e857829003601f168201915b50505050509080600101549080600201805461022090610434565b80601f016020809104026020016040519081016040528092919081815260200182805461024c90610434565b80156102975780601f1061026e57610100808354040283529160200191610297565b820191905f5260205f20905b81548152906001019060200180831161027a57829003601f168201915b5050505050908060030154905084565b634e487b7160e01b5f52604160045260245ffd5b5f82601f8301126102ca575f5ffd5b813567ffffffffffffffff8111156102e4576102e46102a7565b604051601f8201601f19908116603f0116810167ffffffffffffffff81118282101715610313576103136102a7565b60405281815283820160200185101561032a575f5ffd5b816020850160208301375f918101602001919091529392505050565b5f5f5f60608486031215610358575f5ffd5b833567ffffffffffffffff81111561036e575f5ffd5b61037a868287016102bb565b93505060208401359150604084013567ffffffffffffffff81111561039d575f5ffd5b6103a9868287016102bb565b9150509250925092565b5f602082840312156103c3575f5ffd5b5035919050565b5f81518084528060208401602086015e5f602082860101526020601f19601f83011685010191505092915050565b608081525f61040a60808301876103ca565b856020840152828103604084015261042281866103ca565b91505082606083015295945050505050565b600181811c9082168061044857607f821691505b60208210810361046657634e487b7160e01b5f52602260045260245ffd5b50919050565b601f8211156104b357805f5260205f20601f840160051c810160208510156104915750805b601f840160051c820191505b818110156104b0575f815560010161049d565b50505b505050565b815167ffffffffffffffff8111156104d2576104d26102a7565b6104e6816104e08454610434565b8461046c565b6020601f821160018114610518575f83156105015750848201515b5f19600385901b1c1916600184901b1784556104b0565b5f84815260208120601f198516915b828110156105475787850151825560209485019460019092019101610527565b508482101561056457868401515f19600387901b60f8161c191681555b50505050600190811b0190555056fea2646970667358221220b97e315a7e89422897cc657ebeff0edb9edb441e5dc53403df391a4ba480544f64736f6c634300081b0033";
//
//    private static String librariesLinkedBinary;
//
//    public static final String FUNC_TRANSACTIONS = "transactions";
//
//    public static final String FUNC_LOGTRANSACTION = "logTransaction";
//
//    public static final String FUNC_GETTRANSACTIONCOUNT = "getTransactionCount";
//
//    public static final Event TRANSACTIONLOGGED_EVENT = new Event("TransactionLogged",
//            Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}, new TypeReference<Uint256>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Uint256>() {}));
//    ;
//
//    protected static final HashMap<String, String> _addresses;
//
//    static {
//        _addresses = new HashMap<String, String>();
//        _addresses.put("5777", "0x295CB5327d2aBaE76D793AD537186C573fA6564E");
//    }
//
//    @Deprecated
//    protected InventoryTransactions(String contractAddress, Web3j web3j, Credentials credentials,
//            BigInteger gasPrice, BigInteger gasLimit) {
//        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
//    }
//
//    protected InventoryTransactions(String contractAddress, Web3j web3j, Credentials credentials,
//            ContractGasProvider contractGasProvider) {
//        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
//    }
//
//    @Deprecated
//    protected InventoryTransactions(String contractAddress, Web3j web3j,
//            TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
//        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
//    }
//
//    protected InventoryTransactions(String contractAddress, Web3j web3j,
//            TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
//        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
//    }
//
////    public static List<TransactionLoggedEventResponse> getTransactionLoggedEvents(
////            TransactionReceipt transactionReceipt) {
////        List<Contract.EventValuesWithLog> valueList = staticExtractEventParametersWithLog(TRANSACTIONLOGGED_EVENT, transactionReceipt);
////        ArrayList<TransactionLoggedEventResponse> responses = new ArrayList<TransactionLoggedEventResponse>(valueList.size());
////        for (Contract.EventValuesWithLog eventValues : valueList) {
////            TransactionLoggedEventResponse typedResponse = new TransactionLoggedEventResponse();
////            typedResponse.log = eventValues.getLog();
////            typedResponse.itemName = (String) eventValues.getNonIndexedValues().get(0).getValue();
////            typedResponse.quantity = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
////            typedResponse.transactionType = (String) eventValues.getNonIndexedValues().get(2).getValue();
////            typedResponse.timestamp = (BigInteger) eventValues.getNonIndexedValues().get(3).getValue();
////            responses.add(typedResponse);
////        }
////        return responses;
////    }
//
//    public static TransactionLoggedEventResponse getTransactionLoggedEventFromLog(Log log) {
//        Contract.EventValuesWithLog eventValues = staticExtractEventParametersWithLog(TRANSACTIONLOGGED_EVENT, log);
//        TransactionLoggedEventResponse typedResponse = new TransactionLoggedEventResponse();
//        typedResponse.log = log;
//        typedResponse.itemName = (String) eventValues.getNonIndexedValues().get(0).getValue();
//        typedResponse.quantity = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
//        typedResponse.transactionType = (String) eventValues.getNonIndexedValues().get(2).getValue();
//        typedResponse.timestamp = (BigInteger) eventValues.getNonIndexedValues().get(3).getValue();
//        return typedResponse;
//    }
//
//    public Flowable<TransactionLoggedEventResponse> transactionLoggedEventFlowable(
//            EthFilter filter) {
//        return web3j.ethLogFlowable(filter).map(log -> getTransactionLoggedEventFromLog(log));
//    }
//
//    public Flowable<TransactionLoggedEventResponse> transactionLoggedEventFlowable(
//            DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
//        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
//        filter.addSingleTopic(EventEncoder.encode(TRANSACTIONLOGGED_EVENT));
//        return transactionLoggedEventFlowable(filter);
//    }
//
//    public RemoteFunctionCall<Tuple4<String, BigInteger, String, BigInteger>> call_transactions(
//            BigInteger param0) {
//        final Function function = new Function(FUNC_TRANSACTIONS,
//                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(param0)),
//                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}, new TypeReference<Uint256>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Uint256>() {}));
//        return new RemoteFunctionCall<Tuple4<String, BigInteger, String, BigInteger>>(function,
//                new Callable<Tuple4<String, BigInteger, String, BigInteger>>() {
//                    @Override
//                    public Tuple4<String, BigInteger, String, BigInteger> call() throws Exception {
//                        List<Type> results = executeCallMultipleValueReturn(function);
//                        return new Tuple4<String, BigInteger, String, BigInteger>(
//                                (String) results.get(0).getValue(),
//                                (BigInteger) results.get(1).getValue(),
//                                (String) results.get(2).getValue(),
//                                (BigInteger) results.get(3).getValue());
//                    }
//                });
//    }
//
//    public RemoteFunctionCall<TransactionReceipt> send_transactions(BigInteger param0) {
//        final Function function = new Function(
//                FUNC_TRANSACTIONS,
//                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(param0)),
//                Collections.<TypeReference<?>>emptyList());
//        return executeRemoteCallTransaction(function);
//    }
//
//    public RemoteFunctionCall<TransactionReceipt> send_logTransaction(String itemName,
//            BigInteger quantity, String transactionType) {
//        final Function function = new Function(
//                FUNC_LOGTRANSACTION,
//                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(itemName),
//                new org.web3j.abi.datatypes.generated.Uint256(quantity),
//                new org.web3j.abi.datatypes.Utf8String(transactionType)),
//                Collections.<TypeReference<?>>emptyList());
//        return executeRemoteCallTransaction(function);
//    }
//
//    public RemoteFunctionCall<BigInteger> call_getTransactionCount() {
//        final Function function = new Function(FUNC_GETTRANSACTIONCOUNT,
//                Arrays.<Type>asList(),
//                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
//        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
//    }
//
//    public RemoteFunctionCall<TransactionReceipt> send_getTransactionCount() {
//        final Function function = new Function(
//                FUNC_GETTRANSACTIONCOUNT,
//                Arrays.<Type>asList(),
//                Collections.<TypeReference<?>>emptyList());
//        return executeRemoteCallTransaction(function);
//    }
//
//    @Deprecated
//    public static InventoryTransactions load(String contractAddress, Web3j web3j,
//            Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
//        return new InventoryTransactions(contractAddress, web3j, credentials, gasPrice, gasLimit);
//    }
//
//    @Deprecated
//    public static InventoryTransactions load(String contractAddress, Web3j web3j,
//            TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
//        return new InventoryTransactions(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
//    }
//
//    public static InventoryTransactions load(String contractAddress, Web3j web3j,
//            Credentials credentials, ContractGasProvider contractGasProvider) {
//        return new InventoryTransactions(contractAddress, web3j, credentials, contractGasProvider);
//    }
//
//    public static InventoryTransactions load(String contractAddress, Web3j web3j,
//            TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
//        return new InventoryTransactions(contractAddress, web3j, transactionManager, contractGasProvider);
//    }
//
//    public static RemoteCall<InventoryTransactions> deploy(Web3j web3j, Credentials credentials,
//            ContractGasProvider contractGasProvider) {
//        return deployRemoteCall(InventoryTransactions.class, web3j, credentials, contractGasProvider, getDeploymentBinary(), "");
//    }
//
//    @Deprecated
//    public static RemoteCall<InventoryTransactions> deploy(Web3j web3j, Credentials credentials,
//            BigInteger gasPrice, BigInteger gasLimit) {
//        return deployRemoteCall(InventoryTransactions.class, web3j, credentials, gasPrice, gasLimit, getDeploymentBinary(), "");
//    }
//
//    public static RemoteCall<InventoryTransactions> deploy(Web3j web3j,
//            TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
//        return deployRemoteCall(InventoryTransactions.class, web3j, transactionManager, contractGasProvider, getDeploymentBinary(), "");
//    }
//
//    @Deprecated
//    public static RemoteCall<InventoryTransactions> deploy(Web3j web3j,
//            TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
//        return deployRemoteCall(InventoryTransactions.class, web3j, transactionManager, gasPrice, gasLimit, getDeploymentBinary(), "");
//    }
//
////    public static void linkLibraries(List<Contract.LinkReference> references) {
////        librariesLinkedBinary = linkBinaryWithReferences(BINARY, references);
////    }
//
//    private static String getDeploymentBinary() {
//        if (librariesLinkedBinary != null) {
//            return librariesLinkedBinary;
//        } else {
//            return BINARY;
//        }
//    }
//
//    protected String getStaticDeployedAddress(String networkId) {
//        return _addresses.get(networkId);
//    }
//
//    public static String getPreviouslyDeployedAddress(String networkId) {
//        return _addresses.get(networkId);
//    }
//
//    public static class TransactionLoggedEventResponse extends BaseEventResponse {
//        public String itemName;
//
//        public BigInteger quantity;
//
//        public String transactionType;
//
//        public BigInteger timestamp;
//    }
//}
