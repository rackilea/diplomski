public class WrapperTest {

    private JPanel jPanel;
    private JLabel jLabel;

    public WrapperTest(JPanel jPanel, JLabel jLabel) {
        super();
        this.jPanel = jPanel;
        this.jLabel = jLabel;
    }

    public JPanel getjPanel() {
        return jPanel;
    }
    public void setjPanel(JPanel jPanel) {
        this.jPanel = jPanel;
    }
    public JLabel getjLabel() {
        return jLabel;
    }
    public void setjLabel(JLabel jLabel) {
        this.jLabel = jLabel;
    }

}