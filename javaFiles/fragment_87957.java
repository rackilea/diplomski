@Autowired
private SimpleClientHttpRequestFactory requestFactoryGetByCustomer;

....

this.requestFactoryGetByCustomer.setConnectTimeout(30_000);