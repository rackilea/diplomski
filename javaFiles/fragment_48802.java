public class TableValuePrint extends JFrame implements ActionListener{
    private final JButton print;
    private final JTable table;

    public TableValuePrint() {

        String[] columnNames = {"A", "B", "C"};
        Object[][] data = {
            {"Moni", "adsad", "Pass"},
            {"Jhon", "ewrewr", "Fail"},
            {"Max", "zxczxc", "Pass"}
        };

        table = new JTable(data, columnNames);
        JScrollPane tableSP = new JScrollPane(table);
        JPanel tablePanel = new JPanel();
        tablePanel.add(tableSP);
        tablePanel.setBackground(Color.red);
        add(tablePanel);
        setTitle("Result");

        setSize(1000,700);

        print=new JButton("Print");  
        JPanel jpi1 = new JPanel();  
        jpi1.add(print);  
        tablePanel.add(jpi1,BorderLayout.SOUTH);      

        print.addActionListener(this);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            public void run() {
                TableValuePrint ex = new TableValuePrint();
                ex.setVisible(true);
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
       if(ae.getSource()==print){
         int rowIndex = table.getSelectedRow();
         int colIndex = table.getSelectedColumn();
         String s=(String) table.getValueAt(rowIndex,colIndex);
         System.out.println("INNERTABLE:" + rowIndex + "*" + colIndex+" "+s);
        }
    }
}