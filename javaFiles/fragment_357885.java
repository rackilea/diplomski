public SubControllerB {
    private Model model;
    //label defined in subView B
    @FXML
    private Label labelB;

    public void setModel(Model model){
        this.model=model;
        model.buttonPressedProperty.addListener((observable, oldValue, newValue)->{
            doSomethingOnLabelB();
        });
    }

    private void doSomethingOnLabelB() { ... }
}