@Slf4j
@Service
@RequiredArgsConstructor
public class DamlContractSvc implements InitializingBean {
    @Value("${daml.host}")
    private String host;
    @Value("${daml.port}")
    private int port;
    @Value("${daml.appId}")
    private String appId;
    @Value("${daml.party}")
    private String party;
    @Value("${daml.packageId}")
    private String packageId;

    @Autowired(required = true)
    private ContractRepo contractRepo;

    private DamlLedgerClient client;

    private final static AtomicReference<LedgerOffset> OFFSET = new AtomicReference<>(
            LedgerOffset.LedgerBegin.getInstance());

    @Scheduled(fixedDelay = 5000)
    public void fetch() {
        final TransactionFilter transactionFilter = new FiltersByParty(
                Collections.singletonMap(party, NoFilter.instance));
        client.getTransactionsClient().getTransactions(OFFSET.get(), transactionFilter, true).flatMapIterable(t -> {
            OFFSET.set(new LedgerOffset.Absolute(t.getOffset()));
            return t.getEvents();
        }).forEach(contractRepo);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        client = DamlLedgerClient.forHostWithLedgerIdDiscovery(host, port, Optional.empty());
        client.connect();
    }
}