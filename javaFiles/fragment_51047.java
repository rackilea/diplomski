private Register mRegister;

public Controller() {
    this.mRegister = new Register(this);
}

@FXML
private void initialize() {
    mRegister.importFrom(new File("prices.txt"));
}