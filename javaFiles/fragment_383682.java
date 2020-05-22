public class TestTreeRenderer {

    public static void main(String[] args) {
        new TestTreeRenderer();
    }

    public TestTreeRenderer() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                JFrame frame = new JFrame("Test");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                frame.add(new TreePane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }

        });
    }

    public class TreePane extends JPanel {

        private JTree tree;

        public TreePane() {
            // THIS IS VERY IMPORTANT
            // You must set this BEFORE creating ANY trees!!
            UIManager.put("Tree.rendererFillBackground", false);

            setLayout(new BorderLayout());
            tree = new JTree();
            tree.setBackground(Color.BLUE);

            System.out.println("Loading files...");
            File root = new File("/etc");
            DefaultMutableTreeNode rootNode = new DefaultMutableTreeNode(root.getName());
            for (File file : root.listFiles()) {
                rootNode.add(new DefaultMutableTreeNode(file.getName()));
            }
            System.out.println("Loading model");
            DefaultTreeModel model = new DefaultTreeModel(rootNode);
            tree.setModel(model);

            add(new JScrollPane(tree));
        }
    }
}