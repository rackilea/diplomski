public BallComponent()
{
    super();
    super.setFocusable(true);

    InputMap imap1 = this.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    imap1.put(KeyStroke.getKeyStroke("ctrl Y"), "keyUp1");
    InputMap imap2 = this.getInputMap(JComponent.WHEN_FOCUSED);
    imap1.put(KeyStroke.getKeyStroke("ctrl Y"), "keyUp2");
    InputMap imap3 = this.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);   
    imap1.put(KeyStroke.getKeyStroke("ctrl Y"), "keyUp3");

    actionPress = new ActionPress();
    ActionMap amap = this.getActionMap();
    amap.put("keyUp1", actionPress);
    amap.put("keyUp2", actionPress);    
    amap.put("keyUp3", actionPress);
}