public SubControllerA {
    private Model model;
    //button defined in subView A
    @FXML
    private Button buttonA;

    public void setModel(Model model){
        this.model=model;
        model.buttonPressedProperty.addListener((observable, oldValue, newValue)->{
            doSomethingOnSubViewA();
        });
    }

    private void doSomethingOnSubViewA() { ... }

    //method to handle buttonA click
    @FXML
    private void handleButtonAClick(){
        model.setButtonPressed(true);
    }
}