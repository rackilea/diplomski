public class JTabbedPaneExample extends JFrame {

    private JTabbedPane tabbedPane;
    private JPanel panel1, panel2, panel3;
    private int currentTabIndex = 0, previousTabIndex = 0;
    private boolean valid = false;
    private JButton changeVariableBtn;

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
        changeVariableBtn = new JButton("Set validation to true");
        tabbedPane.insertTab("tab1", null, panel1, null, 0);
        tabbedPane.insertTab("tab2", null, panel2, null, 1);
        tabbedPane.insertTab("tab3", null, panel3, null, 2);
        contentPane.add(tabbedPane, BorderLayout.NORTH);
        contentPane.add(changeVariableBtn, BorderLayout.CENTER);
    }

    private void addListeners() {
        tabbedPane.addChangeListener(new ChangeListener() {

            private boolean automatedStateChange = false;

            @Override
            public void stateChanged(ChangeEvent ce) {
                //this is used so when we allow the user not to go to the new tab by setting the tabb index to the previous one we dont want our changelistener to fire again as if the user were changing the tabs
                if (automatedStateChange) {
                    automatedStateChange = false;
                } else {
                    previousTabIndex = currentTabIndex;
                    currentTabIndex = tabbedPane.getSelectedIndex();
                }

                if (valid) {
                    System.out.println("Current tab is:" + currentTabIndex);
                    System.out.println("Previous tab is:" + previousTabIndex);
                    System.out.println("Validation succeeded: " + valid);
                    changeVariableBtn.doClick();
                } else {
                    System.out.println("You need to enter all valid data first!");
                    automatedStateChange = true;
                    tabbedPane.setSelectedIndex(previousTabIndex);
                }
            }
        });
        changeVariableBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                if (valid) {
                    valid = false;
                    changeVariableBtn.setText("Set validation to true");
                } else {
                    valid = true;
                    changeVariableBtn.setText("Set validation to false");
                }
            }
        });
    }
}