import java.util.ArrayList;
import java.util.List;

public class Graph {

    private final List<Node> nodes;
    private final Node root;

    //Graph assumes unique id > 0, and only root with pid = 0
    Graph(Node root){
        this.root = root;
        nodes = new ArrayList<>();
        nodes.add(root);
    };

    void add(Node node){
        nodes.add(node);
    }

    void analyze(){
        //sort by pid so iteration goes from top level down
        nodes.sort( (n1,n2) -> Integer.compare(n1.getPid(), n2.getPid()) );
        for(Node node : nodes){
            Node parent = getNode(node.getPid());
            if (parent == null ) {
                continue;  //skip root
            }
            node.setUpLevel(parent.getUpLevel()+1);  //add 1 to parent value
            node.setUpNum(node.getUpNum() +1);       //increment by 1
            parent.setDowNum(parent.getDowNum() +1); //increment by 1
            updateHigherLevels(node);
        }
    }

    //recursively update higher levels
    private void updateHigherLevels(Node node) {
        Node parent = getNode(node.getPid());
        if(parent == null) return;
        parent.setDownLevel(node.getDownLevel() + 1);
        updateHigherLevels(parent);
    }

    void print(){
        //sort by id for nice printing
        nodes.sort( (n1,n2) -> Integer.compare(n1.getId(), n2.getId()) );
        String format = "\n%2s %3s %4s %5s %7s %7s  %8s";
        System.out.printf(format,"id","pid","name","upnum","uplevel", "downnum" , "downlevel");
        for(Node node : nodes){
            System.out.printf(format, node.getId(), node.getPid(), node.getName(), node.getUpNum(), node.getUpLevel()
                    , node.getDowNum(), node.getDownLevel());
        }
    }

    Node getNode(int id){

        for(Node node : nodes){
            if(node.getId() == id) return node;
        }

        return null;
    }

    public static void main(String[] args) {
        //make graph
        Graph graph = new Graph(new Node(1, 0, "a"));
        graph.add(new Node(2, 1, "b"));
        graph.add(new Node(3, 1, "c"));
        graph.add(new Node(4, 2, "d"));
        graph.add(new Node(5, 2, "e"));

        graph.analyze();
        graph.print();
    }
}

class Node {

    private final int id,pid;
    private int upnum = 0, uplevel = 0, downum = 0,  downlevel = 0;
    private final String name;

    Node(int id, int pid, String name) {
        super();
        this.id = id;
        this.pid = pid;
        this.name = name;
    }

    int getId() { return id; }

    int getPid() { return pid;  }

    String getName() { return name; }

    int getUpNum() { return upnum;  }

    void setUpNum(int upnum) { this.upnum = upnum; }

    int getUpLevel() { return uplevel; }

    void setUpLevel(int uplevel) { this.uplevel = uplevel; }

    int getDowNum() { return downum; }

    void setDowNum(int downum) { this.downum = downum; }

    int getDownLevel() { return downlevel; }

    void setDownLevel(int downlevel) { this.downlevel = downlevel; }
}