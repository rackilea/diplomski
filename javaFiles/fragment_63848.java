public class CustomerTable extends JTable {

    public CustomerTable() {
        this.setModel(new BillingTableModel());
    }
}