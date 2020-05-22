public class MyListener implements MouseListener
{
    // ... code ...

    public void mouseClicked(MouseEvent event)
    {
        if (event.getButton() == MouseButton.BUTTON3)
        {
            // Right-click happened
        }
    }
}