Thread t = new Thread()
{
   public void run()
   {
        try
        {
            PR.runProgram();
        }
        catch ( final IOException iox )
        {
             Display.getDefault().asyncExec( new Runnable()
             {
                 public void run()
                 {
                     MessageBox mb = new MessageBox(m_Shell, SWT.ICON_ERROR);
                     mb.setMessage(iox.getMessage());
                     mb.open();

                 }
             });

        }
   }
});

t.start();