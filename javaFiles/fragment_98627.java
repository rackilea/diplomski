public class MenuItem implements MouseListener
{
    ...
    @Override public void mouseClicked(MouseEvent event)
    {
        ActionListener[] listeners = (ActionListener[])
            MenuItem.this.getListeners(ActionListener.class);
        for(int i = 0; i < listeners.length; i++)
        {
            listeners[i].actionPerformed
            (
                new ActionEvent(MenuItem.this,someID, someCMDName)
            );
        }
    }