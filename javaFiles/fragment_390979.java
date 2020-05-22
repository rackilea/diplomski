public void showLoginScreen(){
    try {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("LoginScreen.fxml"));
        LoginController controller = new LoginController();
        controller.initLogin(this);
        loader.setController(controller);
        scene.setRoot((Parent) loader.load()); 
    } catch (Exception ex) {
        Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
    }
}