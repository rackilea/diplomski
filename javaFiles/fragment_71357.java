public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    DocumentBuilder builder = factory.newDocumentBuilder();
    File f = new File("Elements2.xml");
    Document d = builder.parse(f);
    Node  node= d.getDocumentElement();
    DefaultMutableTreeNode parent = new DefaultMutableTreeNode();
    parent = buildTreeNode( parent, node);
    final DefaultMutableTreeNode finalnode = parent;

    javax.swing.SwingUtilities.invokeLater(new Runnable() {
        public void run() {
            createAndShowGUI(finalnode);
        }
          });


}

private static void createAndShowGUI(DefaultMutableTreeNode parent){
    final JFrame frame = new JFrame("Split Pane Example");
    // Display the window.
    frame.setSize(500, 300);
    frame.setVisible(true);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    // set grid layout for the frame
    frame.getContentPane().setLayout(new GridLayout(1, 1));

    JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
    tabbedPane.addTab("IRIS", makePanel("IRIS", parent, 0));
    tabbedPane.addTab("NAAQS", makePanel("NAAQS", parent, 1));
    frame.getContentPane().add(tabbedPane);
}

private static JPanel makePanel(String text, DefaultMutableTreeNode parent, int i) {
            JPanel p = new JPanel();
            //p.add(new Label(text));
            p.setLayout(new GridLayout(1, 1));
            JTree jtree = new JTree(parent.getChildAt(i));
            JScrollPane sp = new JScrollPane(jtree);
            p.add(sp);
            return p;
        }

private static boolean specialCase = false;
private static DefaultMutableTreeNode buildTreeNode(DefaultMutableTreeNode parent, Node parentNode){
    DefaultMutableTreeNode currentLevel = null;
    if (parentNode.getNodeName().equals("treeNode")){
        NodeList children = parentNode.getChildNodes();
        for (int i =0 ;i<children.getLength();i++){
            Node node = children.item(i);
            if (node.getNodeName().equals("reference") && !node.hasChildNodes()){
                currentLevel = new DefaultMutableTreeNode("root");
                specialCase = true;

            }
            else if (node.getNodeName().equals("reference") && node.hasChildNodes()){
                NodeList dataFields = node.getChildNodes();
                for (int j =0 ;j<dataFields.getLength();j++){
                    Node dataField = dataFields.item(j);
                    NamedNodeMap attributes = dataField.getAttributes();
                    if (attributes!=null && attributes.item(0).toString().contains("labelFieldValue")){
                        String attr = attributes.item(1).toString();
                        currentLevel = new DefaultMutableTreeNode("@"+attr);
                        parent.add(currentLevel);
                        break;
                    }                   
                }
            }
            else if (node.getNodeName().equals("treeNode") && node.hasChildNodes() && specialCase){
                specialCase = false;
                parent = buildTreeNode(currentLevel,node);
            }
            else if (node.getNodeName().equals("treeNode") && node.hasChildNodes() && !specialCase){
                currentLevel = buildTreeNode(currentLevel,node);
            }
        }
    }
    return parent;
}