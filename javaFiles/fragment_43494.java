public class TableExample extends JFrame implements ActionListener {

        JFrame f;
        JPanel p1;
        JPanel jPanel1;
        JTable jTable1;

        TableExample() {

            JFrame f;
        JPanel p1;
        JPanel jPanel1;
        JTable jTable1;

        f = new JFrame("Home123");
        f.setSize(getMaximumSize());

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        p1 = new JPanel();
        p1.setBackground(Color.red);
        p1.setLayout(new BorderLayout());
        f.add(p1);

        String[] headers = {"First Name", "Last Name", "Age"};
        Object[][] data = {
            {"Kathy", "Smith", new Integer(25)},};

        jTable1 = new JTable(data, headers);
        JScrollPane scrollPane = new JScrollPane(jTable1);
        scrollPane.setSize(500,500);
        jTable1.setSize(500,500);
        p1.add(scrollPane);
        f.pack();
        f.setVisible(true);
        }

    public static void main(String[] args) {
            EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new TableExample();
            }
        });
        }

        @Override
            public void actionPerformed(ActionEvent e) {
            try {
                System.out.println("");

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }