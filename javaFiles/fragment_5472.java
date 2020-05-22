public class tttt extends JFrame{
    private JTable tab;
    private JPanel panel1;
    private JButton btnAddData;

    private void createUIComponents() {//Custom Create for tab
        Object[][] data1 =  {{'1'}};
        Object[] data2 = {'2'};
        tab = new JTable(data1, data2);
        btnAddData = new JButton("Refresh");

        btnAddData.addActionListener(e->Refresh());

        panel1 = new JPanel(new BorderLayout(10, 10));
        panel1.add(btnAddData, BorderLayout.NORTH);
        panel1.add(tab, BorderLayout.CENTER);
    }

    public void CreateFrame(){
        createUIComponents();
        setContentPane(panel1);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }

    public void Refresh(){
        Object[][] data1 =  {{'9'}};
        Object[] data2 = {'9'};
        tab.setModel(new DefaultTableModel(data1, data2));
        revalidate();
    }

    public static void main(String[] args) {
        tttt Frame = new tttt();//create frame with table with '1'
        Frame.CreateFrame();
//        Frame.Refresh();//frame doesn`t change

    }

}