EventQueue eventQueue = Toolkit.getDefaultToolkit().getSystemEventQueue();
    eventQueue.push(new EventQueue(){
        public void postEvent(AWTEvent theEvent) {
            if(theEvent instanceof KeyEvent){
                KeyEvent kEvent = (KeyEvent)theEvent;
                if(kEvent.getKeyCode() == KeyEvent.VK_ESCAPE){
                    System.out.println("escape pressed, set breakpoint here");
                }
            }
            super.postEvent(theEvent);
        }
    });