@RestController
public class NodeController {

    private final NodeInformation nodeInformation;

    @Autowired
    public NodeController(NodeInformation nodeInformation) {
        this.nodeInformation = nodeInformation;
    }

    @RequestMapping("/id")
    public int getNodeId() {
        return this.nodeInformation.getId();
    }
}