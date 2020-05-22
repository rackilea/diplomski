public class ButtonHandler extends AbstractAction {
    private JComponent componentToDisable;
    public ButtonHandler(JComponent comp, String text) {
        super(text);
        componentToDisable = comp;
    }
    public void actionPerformed(ActionEvent event) {
       componentToDisable.setEnabled(false);
    }
}