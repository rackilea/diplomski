public void mouseClicked(MouseEvent event)
{
    if (event.getButton() == MouseEvent.BUTTON1)
    {
        if (timer.isRunning()) {
            timer.stop();
        }
        else {
            timer.start();
        }
    }
}