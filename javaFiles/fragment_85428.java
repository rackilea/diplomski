LayerUI<JComponent> ui = new LayerUI<JComponent>() {

        @Override
        protected void processMouseEvent(MouseEvent e, JLayer<? extends JComponent> l) {
             System.out.println(e.getSource().getClass() + " at " + e.getPoint());
        } 
    };
    JLayer<JComponent> layer = new JLayer<JComponent>(mainPanel, ui);
    layer.setLayerEventMask(AWTEvent.MOUSE_EVENT_MASK );