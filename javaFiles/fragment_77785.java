class CreateAccountButtonPress implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        if (view.getPasswordTextField().equals(view.getConfirmPasswordTextField())) {
            model.addToList(new User(view.getUsernameTextField(), view.getPasswordTextField())); 
            view.dispose();
            LoginView view = new LoginView();
            // LoginModel model = new LoginModel();

            // use the original updated model
            LoginController controller = new LoginController(model, view);
            view.setVisible(true);
        } else {
            System.out.println("password no match");
        }
    }
}