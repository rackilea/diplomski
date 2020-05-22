final JTextArea area = new JTextArea("replacement ..") {

    @Override
    public synchronized void addMouseListener(MouseListener l) {
        LOG.info("adding here ...?");
    }

    @Override
    public synchronized void addMouseMotionListener(
            MouseMotionListener l) {
    }

    @Override
    public synchronized void addMouseWheelListener(
            MouseWheelListener l) {
    }

    @Override
    public void addNotify() {
        disableEvents(AWTEvent.MOUSE_EVENT_MASK | 
                AWTEvent.MOUSE_MOTION_EVENT_MASK | 
                AWTEvent.MOUSE_WHEEL_EVENT_MASK);
        super.addNotify();
    }
};