public class GUI extends JFrame {

    private JTable jTable;

    public GUI() {
        jTable = new JTable(10, 10);
        this.getContentPane().add(jTable);
        this.setVisible(true);
        this.pack();
    }

    public void passArrayToTable(Main mainClass) {

        String[] array = mainClass.readFromFile("C:\\file.csv");

        // for (String s : array) {
        // add values to jTable with: jTable.setValueAt(s,row,column);
        // }
    }

    public static void main(String[] args) {
        new GUI().passArrayToTable(new Main());
    }
}