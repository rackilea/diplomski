public class LoginDialog{
  Action afterLoginAction;
  public void setAfterLoginAction( Action action ){
    afterLoginAction = action;
  }
  public void loginButtonPressed(){
    //do your stuff
    if ( afterLoginAction != null ){
      afterLoginAction.actionPerformed( new ActionEvent( ... ) );
    }
  }
}

public class StartScreen extends JWindow{
  public void showLoginScreen(){
    LoginDialog loginDialog = new LoginDialog();
    loginDialog.setAfterLoginAction( new Action(){
       @Override
       public void actionPerformed( ActionEvent e ){
           StartScreen.this.dispose();
       }
     } );
    loginDialog.setVisible( true );
  }
}