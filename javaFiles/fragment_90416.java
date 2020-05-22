private RestitService restitService;
private final HashMap<K, V> map;

@Autowired
public RestitController(RestitService restitService) {
    this.restitService = restitService;
    this.map = restitService.makeMap();
}