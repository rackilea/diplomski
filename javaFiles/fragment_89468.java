public class ReuseableButton extends JButton implements ActionListener {
    // I want a generic type here, not just HandlerA!
    private AbstractHandler ClickHandler;

    public Controller() {
        //...

        ReuseableButton b = new ReuseableButton(pane,"Reuseable Button A");
        AbstractHandler handlerA = new ConcreteHandlerA();
        b.SetClickHandler(handlerA);

        // ...
    }
}