Toolkit.getDefaultToolkit().addAWTEventListener(new AWTEventListener() {
    @Override
    public void eventDispatched(AWTEvent awte) {//all mouse events will be processed here you will have to check for the mouse events you are interested in
    System.out.println(awte);
    }
}, AWTEvent.MOUSE_EVENT_MASK);//for Mouse events only