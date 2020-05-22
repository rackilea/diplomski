public class JTable_1D extends JFrame {

    protected void frameInit() {
        super.frameInit();
        setTitle("_JTable_1B_");
        setSize(750, 300);                              // doesn't work?
        setLayout(new BorderLayout());
        setVisible(true);

        JTable      jTable = JTab_1D.getJTable(7, 5);   // get a new JTable
        JScrollPane jSPane = new JScrollPane(jTable);   // *      a JSPane w/ this JTable
        add(jSPane, BorderLayout.WEST);                 // add JSPane to area WEST
    }

    public static void main(String[] args) {

        JTable_1D frame = new JTable_1D();

        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        frame.pack();
        frame.setVisible(true);
    }
}