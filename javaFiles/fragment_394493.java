int buttonOutput =myIO.showConfirmDialog(null, "Try Again?", "Try Again?", myIO.YES_NO_OPTION);
    if (buttonOutput != myIO.YES_OPTION)
    {
        System.exit(1);
    }
    String inputText1 = myIO.showInputDialog("Please Enter an Object: ");