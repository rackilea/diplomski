public ButtonPanel(ParentFrame parent){
    parentFrame = parent;

    buttonStatus = "idle";
    //Create Buttons

    AddButtonListener buttonListener = new AddButtonListener(this);
    //rest the code