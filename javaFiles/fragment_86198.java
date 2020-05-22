@FXML
private void loginButton(ActionEvent event) throws  IOException
{

    if (outputToServer == null)
        System.out.println("NULL IN LOGIN BUTTON FUNCTION");
    String t = Input.getText();
    //validateUsername(t);
    System.out.println(t);
    loader();
    validateUsername(t);
}