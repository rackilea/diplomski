public static void main(String args[]) 
{
    java.awt.EventQueue.invokeLater
    (
        new Runnable() 
        {
            @Override
            public void run() 
            {
                ImageLoadingWorker ilw = new ImageLoadingWorker();

                // add a PropertyChangeListener to the SwingWorker
                // when the PCL tells you that the SwingWorker is done, show the mainFrame.

                ilw.execute();

                // .... code for showing the dialog is here.

                //  new MainFrame().setVisible(true);  // done in PCL
            }
        }
    );
}