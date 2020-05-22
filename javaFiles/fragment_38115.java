public LoginViewImpl(){
    //skip
    loginButton.addClickListener(this);
    layout.addComponent(loginButton);
    setCompositionRoot(layout);
}