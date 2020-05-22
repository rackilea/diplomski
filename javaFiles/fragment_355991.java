public class CustomAction extends AbstractAction {

    private JMenuItem item;

    public CustomAction() {
        super("Initial Text");
    }

    public void setJMenuItem(JMenuItem item) {
        this.item = item;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        item.setText("Different Text");
    }

}