// Prints event emitted from a deployed contract
// Event definition:
// event MyEvent(address indexed _address, uint256 _oldValue, uint256 _newValue);
public static void eventTest() {
  try {
    Web3j web3j = Web3j.build(new HttpService());

    Event event = new Event("MyEvent",
                            Arrays.asList(new TypeReference<Address>() {}),
                            Arrays.asList(new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}));

    // Note contract address here. See https://github.com/web3j/web3j/issues/405
    EthFilter filter = new EthFilter(DefaultBlockParameterName.EARLIEST, DefaultBlockParameterName.LATEST, "6dd7c1c13df7594c27e0d191fd8cc21efbfc98b4");

    filter.addSingleTopic(EventEncoder.encode(event));

    web3j.ethLogObservable(filter).subscribe(log -> System.out.println(log.toString()));
  }
  catch (Throwable t) {
    t.printStackTrace();
  }
}