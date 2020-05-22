class MyButton extends Component {
    private Button button;
    private Label label;

    public MyButton(String label, String buttonLabel) {
        label = new Label(label);
        button = new Button(buttonLabel);
    }

    public paint(Graphics g) {
        label.paint(g);
        button.paint(g);
    }

    ...
}