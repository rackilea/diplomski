public class CoreApplicationCPane extends JPanel {

    protected static final String LOGIN_VIEW = "View.login";
    protected static final String APPLICATION_VIEW = "View.application";

    private LoginView loginView;
    private ApplicationPane applicationView;
    private CardLayout cardLayout;

    public CoreApplicationCPane() {

        cardLayout = new CardLayout();
        setLayout(cardLayout);

        loginView = new LoginPane();
        applicationView = new ApplicationPane();
        add(loginView.getView(), LOGIN_VIEW);
        add(applicationView.getView(), APPLICATION_VIEW);
        loginView.setController(new LoginController() {

            @Override
            public void performLogin(LoginView view) {
                // Do what ever you need to do...
                String name = view.getUserName();
                char[] password = view.getPassword();
                //...

                cardLayout.show(CoreApplicationCPane.this, APPLICATION_VIEW);
            }

            @Override
            public void loginCanceled(LoginView view) {
                SwingUtilities.windowForComponent(CoreApplicationCPane.this).dispose();
            }
        });

        cardLayout.show(this, LOGIN_VIEW);

    }

}