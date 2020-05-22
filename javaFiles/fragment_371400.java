public class MyFrame extends Frame
  {
  private MessageBox mb_ = new MessageBox();
  //private helper used by this class
  private void showMessage(String message)
  {
    //set the message text
    mb_.setMessage( message );
    mb_.pack();
    mb_.show();
  }
}