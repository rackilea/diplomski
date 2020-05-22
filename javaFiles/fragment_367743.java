JFileChooser chooser = new JFileChooser();
chooser.addActionListener( new ActionListener() 
{
    public void actionPerformed(ActionEvent e) 
    {
       if( e.getActionCommand().equals("CancelSelection") )
       {
            chooser.cancelSelection();
       }
    }
} );

public void forceCancel()
{
   ActionEvent e = new ActionEvent(chooser, ActionEvent.ACTION_PERFORMED, "CancelSelection");
   fireActionPerformed(e);
}

public void fireActionPerformed( ActionEvent e )
{
   ActionListener[] listeners = chooser.getActionListeners();
  for( ActionListener listener : listeners )
  {
     listener.actionPerformed( e );
  }
}