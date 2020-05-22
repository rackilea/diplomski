public class ButtonSel extends JFrame {
    ... other fields ...

    // Note: it's a good idea to make all fields private
    private ButtonGroup groupOfRadioButtons = new ButtonGroup();

    public ButtonSel() {
        super("ButtonTest");
        ...
        groupOfRadioButtons.add(oneButton);
        groupOfRadioButtons.add(twoButton);
        groupOfRadioButtons.add(threeButton);
    }
}