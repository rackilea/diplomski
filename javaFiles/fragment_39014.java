public class StockDropdown extends JPanel {
    private JButton bt = new JButton("tsfdsfds");
    private JPanel top = new JPanel();
    private JPanel middle = new JPanel();

    public StockDropdown() {
        setLayout(new BorderLayout());
        top.add(bt);
        // add("North", top);
        add(top, BorderLayout.PAGE_START);
    }
}