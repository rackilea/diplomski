public class Button extends JButton {
    private String actionName;
    public Button(String actionName) {
        this.actionName = actionName;
        JButton button = new JButton();
        button.setText(actionName);
        button.setSize(30, 30);             
        button.setBounds(5, 5, 25, 25);     

        button.addActionListener(new Evt(this.actionName));
    }
}