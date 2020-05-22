private Label potsizeLabel;
private Label stacksizeLabel;
private Label betsizeLabel;

private void initPot() {
    int potSizeValue = Potsize.getPotSize();
    int betSizeValue = Potsize.getBetSize();
    int stackSizeValue = Potsize.getStackSize();

    Potsize potsize = new Potsize(potSizeValue);
    Potsize betsize = new Potsize(betSizeValue);
    Potsize stacksize = new Potsize(stackSizeValue);

    potsizeLabel.setText(potsize.toString());
    stacksizeLabel.setText(stacksize.toString());
    betsizeLabel.setText(betsize.toString());
}

@Override
public void start(Stage primaryStage) throws Exception {
    ...

    buttonRestart.setOnAction((ActionEvent event) -> {
        // change node properites that could have been modified to their's original states
        imageView1.setRotate(0);
        textConfirm.setText("");

        // redo Potsize thing
        initPot();
    });

    ...

    potsizeLabel = new Label();
    stacksizeLabel = new Label();
    betsizeLabel = new Label();

    initPot();

    ...

}