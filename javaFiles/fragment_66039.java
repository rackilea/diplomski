public class Brouillon extends JFrame {

    public Brouillon() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 

        JPanel jpContent = new JPanel(); 
        JPanel jpCards = new JPanel(); 
        jpContent.setLayout(new BoxLayout(jpContent, BoxLayout.PAGE_AXIS)); 
        CardLayout clSelect = new CardLayout(); 
        jpCards.setLayout(clSelect); 
        JButton jbTest = new JButton(); 
        jbTest.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clSelect.next(jpCards); 
            }
        });
        jpContent.add(jbTest); 
        JPanel jpContainer1 = new JPanel(); 
        JTable jtData1 = new JTable(new Object[2][3], new String[] {"1", "2", "3"}); 
        jtData1.getColumnModel().getColumn(0).setPreferredWidth(150); 
        jtData1.getColumnModel().getColumn(1).setPreferredWidth(150); 
        jtData1.getColumnModel().getColumn(2).setPreferredWidth(50); 
        JPanel jpTemp1 = new JPanel(); 
        jpTemp1.setLayout(new BorderLayout()); 
        jpTemp1.add(jtData1.getTableHeader(), BorderLayout.NORTH); 
        jpTemp1.add(jtData1, BorderLayout.CENTER); 
        JScrollPane jspData1 = new JScrollPane(jpTemp1); 
        jpContainer1.add(jspData1); 

        JPanel jpContainer2 = new JPanel(); 
        JTable jtData2 = new JTable(new Object[2][7], new String[] {"1", "2", "3", "4", "5", "6", "7"}); 
        jtData2.getColumnModel().getColumn(0).setPreferredWidth(150); 
        jtData2.getColumnModel().getColumn(1).setPreferredWidth(150); 
        jtData2.getColumnModel().getColumn(2).setPreferredWidth(150); 
        jtData2.getColumnModel().getColumn(3).setPreferredWidth(150); 
        jtData2.getColumnModel().getColumn(4).setPreferredWidth(150); 
        jtData2.getColumnModel().getColumn(5).setPreferredWidth(150); 
        jtData2.getColumnModel().getColumn(6).setPreferredWidth(50); 
        JPanel jpTemp2 = new JPanel(); 
        jpTemp2.setLayout(new BorderLayout());
        jpTemp2.add(jtData2, BorderLayout.CENTER); 
        jpTemp2.add(jtData2.getTableHeader(), BorderLayout.NORTH); 
        JScrollPane jspData2 = new JScrollPane(jpTemp2); 
        jpContainer2.add(jspData2); 
        jpCards.add(jpContainer2); 
        jpCards.add(jpContainer1); 
        jpContent.add(jpCards); 


        this.getContentPane().add(jpContent); 

        this.pack(); 
        this.setVisible(true); 
    }

    public static void main(String[] args) {
        new Brouillon(); 
    }

}