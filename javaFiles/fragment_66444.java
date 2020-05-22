public class TestPane extends JPanel {

    public TestPane() {
        JEditorPane field = new JEditorPane();
        field.setContentType("text/html");
        field.setText("<html><a href='https://google.com'>Google it</a></html>");
        field.setEditable(false);
        field.setBorder(null);
        field.setOpaque(false);
        setLayout(new GridBagLayout());
        add(field);
    }

}