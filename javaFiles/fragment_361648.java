public class JTabbedPaneExample extends JFrame {

    private JTabbedPane tabbedPane;
    private JPanel panel1, panel2, panel3;
    private int currentTabIndex = 0, previousTabIndex = 0;

    public JTabbedPaneExample() {
        createAndShowUI();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                JTabbedPaneExample jTabbedPaneExample = new JTabbedPaneExample();
            }
        });
    }

    private void createAndShowUI() {
        setTitle("JTabbedPaneExample");
        setSize(300, 300);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        addComponentsToContentPane(getContentPane());
        addListeners();
        //pack();
        setVisible(true);
    }

    private void addComponentsToContentPane(Container contentPane) {
        tabbedPane = new JTabbedPane();
        panel1 = new JPanel();
        panel2 = new JPanel();
        panel3 = new JPanel();
        tabbedPane.insertTab("tab1", null, panel1, null, 0);
        tabbedPane.insertTab("tab2", null, panel2, null, 1);
        tabbedPane.insertTab("tab3", null, panel3, null, 2);
        contentPane.add(tabbedPane);
    }

    private void addListeners() {
        tabbedPane.addChangeListener(new ChangeListener() {

            @Override
            public void stateChanged(ChangeEvent ce) {
                previousTabIndex = currentTabIndex;
                currentTabIndex = tabbedPane.getSelectedIndex();
                System.out.println("Current tab is:" + currentTabIndex);
                System.out.println("Previous tab is:" + previousTabIndex);
            }
        });
    }
}