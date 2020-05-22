@Getter
@Setter
public class NodeInformation {
    private int port;
    private int id;


    public NodeInformation(int port, int id) {
        this.port = port;
        this.id = id;
    }
}