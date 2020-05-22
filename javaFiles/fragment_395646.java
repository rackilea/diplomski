public class ApplicationPane extends JPanel implements View {

    public ApplicationPane() {
        setLayout(new GridBagLayout());
        add(new JLabel("Welcome to my awesome application"));
    }

    @Override
    public JComponent getView() {
        return this;
    }

    @Override
    public void setController(Object controller) {
        // What ever controller you want to use...
    }

    @Override
    public Object getController() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}