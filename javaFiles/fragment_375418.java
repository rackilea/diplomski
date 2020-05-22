private void showSetupAccountScreen()
{
    try 
    {
        spCenterDisplay.getChildren().remove(0);//remove old display            
        BorderPane root = FXMLLoader.load(getClass().getResource("SubSetupAccount.fxml"));
        spCenterDisplay.getChildren().add(root);//add new display
        GridPane tempDisplay = (GridPane)root.getChildren().get(1);//get Parent of the nodes I will be using in this controller
        loadQWERTYKeyboard();            

        TextField tfFirstName = (TextField)findNodeByID("tfFirstName", tempDisplay.getChildren());
        TextField tfLastName = (TextField)findNodeByID("tfLastName", tempDisplay.getChildren());
        TextField tfStreetAddress = (TextField)findNodeByID("tfStreetAddress", tempDisplay.getChildren());
        TextField tfCity = (TextField)findNodeByID("tfCity", tempDisplay.getChildren());
        TextField tfState = (TextField)findNodeByID("tfState", tempDisplay.getChildren());
        TextField tfZip = (TextField)findNodeByID("tfZip", tempDisplay.getChildren());
        TextField tfInitialDepositChecking = (TextField)findNodeByID("tfInitialDepositChecking", tempDisplay.getChildren());
        TextField tfInitialDepositSavings  = (TextField)findNodeByID("tfInitialDepositSavings", tempDisplay.getChildren());
        ChoiceBox cbChecking  = (ChoiceBox)findNodeByID("cbChecking", tempDisplay.getChildren());
        cbChecking.getItems().addAll("No", "Yes");
        cbChecking.setValue("No");
        ChoiceBox cbSavings  = (ChoiceBox)findNodeByID("cbSavings", tempDisplay.getChildren());
        cbSavings.getItems().addAll("No", "Yes");
        cbSavings.setValue("No");            

        if(true)//come back and check to make sure all info is in textfields
        {
            btnLeftOne.setOnAction((event) -> {

                boolean createChecking = cbChecking.getValue().equals("Yes");
                boolean createSavings = cbSavings.getValue().equals("Yes");

                dbh.createNewAccount(tfFirstName.getText(), tfLastName.getText(), tfStreetAddress.getText(), tfCity.getText(), 
                                     tfState.getText(), tfZip.getText(), createChecking, Double.parseDouble(tfInitialDepositChecking.getText()),
                                     createSavings, Double.parseDouble(tfInitialDepositSavings.getText()));
            });
        }
        else
        {
            //create Alert 
        }

        btnRightOne.setOnAction((event) -> {
            cancelAccountCreation();
        });

        btnLeftTwo.setOnAction(null);
        btnLeftThree.setOnAction(null);
        btnLeftFour.setOnAction(null);
        btnRightTwo.setOnAction(null);
        btnRightThree.setOnAction(null);
        btnRightFour.setOnAction(null);
    }
    catch (IOException ex) 
    {
        Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
    }
}

private void loadQWERTYKeyboard()
{
    try 
    {
        AnchorPane keyboardRoot = FXMLLoader.load(getClass().getResource("KeyboardQWERTY.fxml"));
        System.out.println(keyboardRoot.getId());
        spBottomDisplay.getChildren().add(keyboardRoot);

        GridPane tempKeyboard = (GridPane)keyboardRoot.getChildren().get(0);

        tempKeyboard.getChildren().stream().filter((tempNode)
                -> (tempNode instanceof Button)).map((
                        tempNode) -> (Button) tempNode).forEachOrdered((tempButton) -> {
                            buttons.put(tempButton.getText().toLowerCase(), tempButton);
                        });

        apMain.setOnKeyPressed((event) -> {
            Button tempButton = buttons.get(event.getText());
            if (tempButton != null) {
                tempButton.arm();
                tempButton.setStyle("-fx-background-color: blue");
            }
            else if (event.getCode().equals(KeyCode.ENTER)) {
                tempButton = buttons.get("enter");
                tempButton.arm();
                tempButton.setStyle("-fx-background-color: blue");
            }
            else if (event.getCode().equals(KeyCode.BACK_SPACE)) {
                tempButton = buttons.get("backspace");
                tempButton.arm();
                tempButton.setStyle("-fx-background-color: blue");
            }
            else if (event.getCode().equals(KeyCode.SPACE)) {
                tempButton = buttons.get("space");
                tempButton.arm();
                tempButton.setStyle("-fx-background-color: blue");
            }
        });

        apMain.setOnKeyReleased((event) -> {
            System.out.println();
            Button tempButton = buttons.get(event.getText());
            System.out.println("Released key text: " + event.getText());
            System.out.println("Released key code: " + event.getCode());

            if (tempButton != null) {
                tempButton.disarm();
                tempButton.setStyle("");
            }
            else if (event.getCode().equals(KeyCode.ENTER)) {
                tempButton = buttons.get("enter");
                tempButton.disarm();
                tempButton.setStyle("");
            }
            else if (event.getCode().equals(KeyCode.BACK_SPACE)) {
                tempButton = buttons.get("backspace");
                tempButton.disarm();
                tempButton.setStyle("");
            }
            else if (event.getCode().equals(KeyCode.SPACE)) {
                tempButton = buttons.get("space");
                tempButton.disarm();
                tempButton.setStyle("");
            }
        });
    }
    catch (IOException ex) 
    {
        Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
    }
}

private Node findNodeByID(String id, ObservableList<Node> observableList)
{
    for(Node node : observableList)
    {
        if(node.getId().equals(id))
        {
            System.out.println("node found!");
            return node;
        }
        else
        {
            System.out.println("node not found yet!");
        }
    }

    return null;
}