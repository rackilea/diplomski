private class MyLoginForm extends com.vaadin.ui.LoginForm {
//skip

@Override
protected Component createContent(TextField userNameField,
                              PasswordField passwordField,
                              Button loginButton) {
    FormLayout formLayout = new FormLayout();
    formLayout.setMargin(true);
    formLayout.addStyleName("outlined");
    formLayout.addComponents(userNameField, passwordField, loginButton);
    formLayout.setComponentAlignment(loginButton, Alignment.BOTTOM_RIGHT);
    formLayout.setWidth("20em");
    formLayout.setHeight("10em");
    return formLayout;
}
}