public abstract class CheckableItem {
    protected JCheckbox checkbox;
    public boolean isSelected() {
        return checkbox.isSelected();
    }
    public abstract Component getComponent();
}
public class ButtonComp extends CheckableItem {
    private Panel panel;
    public void init() {
        checkbox = new JCheckbox;
        panel = new JPanel();
        panel.add(new JButton());
        panel.add(checkbox);
    }
    public Component getComponent() {
        return panel;
    }
}