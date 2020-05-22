public void showLoginScreen(){
    try {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("LoginScreen.fxml"));
        loader.setControllerFactory((Class<?> controllerType) -> {
            if (controllerType == LoginController.class) {
                LoginController controller = new LoginController();
                controller.initLogin(this);
                return controller ;
            } else {
                try {
                    return controllerType.newInstance();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        });
        scene.setRoot((Parent) loader.load()); 
        LoginController controller = loader.<LoginController>getController();
        controller.initLogin(this);
    } catch (Exception ex) {
        Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
    }
}