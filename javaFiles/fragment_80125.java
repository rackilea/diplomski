public class viewer  extends javax.swing.JFrame {
private static closeInterface Closed;
   private void initComponents() throws IOException
  {
    addWindowListener(new java.awt.event.WindowAdapter()
    {
        @Override
        public void windowClosing(java.awt.event.WindowEvent evt)
        {
            exitApplication();
        }
    });
  }
  private void exitApplication()
  {
    try
    {
        if( document != null )
        {
            document.close();
        }
    }
    catch( IOException io )
    {
        //do nothing because we are closing the application
    }
    Closed.close();
    this.setVisible( false );
    this.dispose();
  }
   public void addListener(closeInterface closed){
    Closed = closed;
  }
}