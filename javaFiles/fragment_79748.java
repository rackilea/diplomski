public class MyCustomButton extends JButton { // Change class name
    private String actionName;
    public MyCustomButton(String actionName) {
        super(actionName); //Sets the text
        this.actionName = actionName;

        button.addActionListener(new Evt(this.actionName));
    }
}