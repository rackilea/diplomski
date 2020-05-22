public static void main(String[] args) throws InterruptedException, InvocationTargetException {
        final JFrame f = new JFrame("test");
        f.setSize(100, 100);


        JLabel l = new JLabel("<html><a href='http://www.google.com'>google</a></html>");
        l.setToolTipText("<html><a href='http://www.google.com'>google</a></html>");


        long mask = AWTEvent.COMPONENT_EVENT_MASK |
//      AWTEvent.CONTAINER_EVENT_MASK |
//      AWTEvent.FOCUS_EVENT_MASK |
//      AWTEvent.KEY_EVENT_MASK |
//      AWTEvent.MOUSE_EVENT_MASK |
//      AWTEvent.MOUSE_MOTION_EVENT_MASK |
        AWTEvent.WINDOW_EVENT_MASK |
        AWTEvent.ACTION_EVENT_MASK |
        AWTEvent.ADJUSTMENT_EVENT_MASK |
        AWTEvent.ITEM_EVENT_MASK |
        AWTEvent.TEXT_EVENT_MASK;

        Toolkit.getDefaultToolkit().addAWTEventListener(new AWTEventListener() {
            @Override
            public void eventDispatched(AWTEvent event) {
                int id = event.getID();
                Object source = event.getSource();
                if (id == 101 && source instanceof JToolTip) {
                    JToolTip tooltip = (JToolTip)source;

                    //System.out.println("" + event.getID() + " " + event.getSource());

                }

            }
        }, mask);
        f.add(l);
        f.setVisible(true);
    }