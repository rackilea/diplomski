public static void main(String[] args)
{
    JFrame jFrame = new JFrame("Add row");
    jFrame.setSize(new Dimension(1280,720));
    jFrame.setLocationRelativeTo(null);
    jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    final String[] columns = new String[]{"C1","C2"};
    String[][] data = new String[][]{new String[]{"A1","A2"},new String[]{"B1","B2"}};

    final JTable jTable = new JTable();
    jTable.setModel(new DefaultTableModel(data,columns));

    jFrame.add(new JScrollPane(jTable),BorderLayout.CENTER);

    JPanel jPanel = new JPanel();
    JButton jButton = new JButton("Add empty row");
    jButton.addActionListener(new ActionListener()
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            System.out.println("'Add' button pressed.");
            DefaultTableModel model = (DefaultTableModel)jTable.getModel();
            model.addRow(new String[columns.length]);
        }
    });

    jPanel.add(jButton);
    jFrame.add(jPanel,BorderLayout.SOUTH);
    jFrame.setVisible(true);
}