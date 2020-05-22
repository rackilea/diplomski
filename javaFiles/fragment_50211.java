//import the DefaultTableModel
import javax.swing.table.DefaultTableModel;

public final class homepage extends javax.swing.JFrame implements ActionListener
{
    DefaultTableModel model_info;
    public homepage() throws InterruptedException
    {
        initComponents();
        create_column();//call method create jtable column names                
    }
}
private void create_column()
{
    model_info=(DefaultTableModel)jTable1_info.getModel();
    model_info.addColumn("Column_Name");
    model_info.addColumn("Column_type");
    model_info.addColumn("Column_size");        
}