public class FormDisablingActionListener implements ActionListener {
    private final Form formToDisable;

    public FormDisablingActionListener(Form formToDisable) {
        this.formToDisable = formToDisable;
    }

    @Override
    public void actionPerformed(ActionEvent e){
        this.formToDisable.setEnabled(false);
        ...
        this.formToDisable.setEnabled(true);
    }
}