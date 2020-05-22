import javax.swing.*;

public class StockDropdown extends JPanel {
    private JButton bt = new JButton("tsfdsfds");
    private JPanel top = new JPanel();
    private JPanel middle = new JPanel();

    // make this private if using factory method
    private StockDropdown(){
       add("North", top);
       top.add(bt);
    }

    // public static factory method
    public static StockDropdown getInstance() {
        StockDropdown ui = new StockDropdown();
        return ui;
    }
}