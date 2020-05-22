public class SelectWindowAction extends AbstractAction {

    private JInternalFrame frame;

    public SelectWindowAction(JInternalFrame frame) {
        putValue(NAME, frame.getTitle());
    }

    public void actionPerformed(ActionEvent evt) {
        frame.setSelected(true);
    }
}