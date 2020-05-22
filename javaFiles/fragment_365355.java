stage.addEventHandler(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>()
{
    @Override
    public void handle(final KeyEvent event)
    {
        if(event.getCode().equals(KeyCode.X)) System.exit(0);
    }
}