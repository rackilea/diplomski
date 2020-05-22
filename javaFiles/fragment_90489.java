Toolkit.getDefaultToolkit().addAWTEventListener(new AWTEventListener() {
    @Override
    public void eventDispatched(final AWTEvent event) {
        if (event.getKeyChar() == KeyEvent.KEY_PRESSED)
        {
            final KeyEvent evt = (KeyEvent) event;
            switch(event.getKeyCode()){
                 //switch statement code
            }
        }   
    }, AWTEvent.KEY_EVENT_MASK);