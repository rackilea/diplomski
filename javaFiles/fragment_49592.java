class EditController {

    private MainFrame mf; //= new MainFrame();

    public EditController(MainFrame mf) {
        this.mf = mf;
        this.mf.validateButton(new ValidateAction());
    }
}