public class Frame2 extends javax.swing.JFrame implements Observer {

    private javax.swing.JTable jTable1;

    public Frame2() {
        initComponents();
    }

    private void initComponents() {
        // I will skip this part you can generate it with NetBeans
        // Basically initialise jTable1
    }

    public void addRow(String column1, String column2){
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.addRow(new Object[]{column1, column2});
    }

    @Override
    public void update(String[] row) {
        addRow(row[0], row[1]);
    }
}