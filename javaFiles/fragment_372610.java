KeyEventDispatcher dispatcher = new KeyEventDispatcher()
{
    public boolean dispatchKeyEvent(KeyEvent e)
    {
        System.out.println(e.getKeyChar());
        return false;
    }
};

DefaultKeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(dispatcher);