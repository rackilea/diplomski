class BtnView extends JButton implements Command {

    Mediator med = Lookup.getDefault().lookup(Mediator.class);

    BtnView(ActionListener al, Mediator m) {
        super("View");
        addActionListener(al);
        med = m;
        med.registerView(this);
    }

    public void execute() {
        med.view();
    }

}