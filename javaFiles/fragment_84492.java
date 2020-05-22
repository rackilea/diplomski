@Autowired
@Qualifier("authRestTemplate")
private RestTemplate authTemplate;

@Autowired
@Qualifier("tokenRestTemplate")
private RestTemplate tokenTemplate;