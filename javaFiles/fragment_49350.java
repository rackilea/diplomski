public interface LoginListener
{
    void onLogin();
    ...
}

public class LoginWidget
{
    public LoginWidget( LoginListener listener ) 
    {
        this.listener = listener;
        Button loginButton = new Button( "Login" );
        loginButton.addClickHandler( new ClickHandler()
        { 
            public void onClick( ClickEvent event ) { listener.onLogin(); }
        } );
    }
    ...
}