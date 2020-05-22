public class NodeTracker extends JFrame {

    private JPanel topPanel;
    private JTable table;
    private JScrollPane scrollPane;
    private Nodes nodes;

    public NodeTracker() {
        setTitle("Node Tracker");
        setSize(700, 700);

        nodes = new Nodes();
        nodes.addNodesListener(new NodesListener() {
            @Override
            public void nodesCircleWasAdded(Nodes source, Circle circle) {
                // A circle was added
            }
        });

        topPanel = new JPanel();
        topPanel.setLayout(new BorderLayout());
        getContentPane().add(topPanel);

        String columns[] = {"Color", "Radius"};

        String data[][]
                        = { //whenever added, would update
                        //{circle.color, circle.radius},
                        //{circle.color, circle.radius}
                        };

        table = new JTable(data, columns);

        scrollPane = new JScrollPane(table);
        topPanel.add(scrollPane, BorderLayout.CENTER);
    }

    //Temporary
    public static void main(String args[]) {
        NodeTracker mainFrame = new NodeTracker();
        mainFrame.setVisible(true);
    }
}