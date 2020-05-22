class DisposingLayerUI extends LayerUI {

    @Override
    public void installUI(JComponent c) {
        super.installUI(c);
        JLayer jlayer = (JLayer)c;
        jlayer.setLayerEventMask(
                AWTEvent.MOUSE_EVENT_MASK 
        );
    }

    @Override
    public void uninstallUI(JComponent c) {
        JLayer jlayer = (JLayer)c;
        jlayer.setLayerEventMask(0);
        super.uninstallUI(c);
    }


    @Override
    protected void processMouseEvent(MouseEvent e, JLayer l) {
        if (e.getID() == MouseEvent.MOUSE_ENTERED) {
            timer.stop();
        } else if (e.getID() == MouseEvent.MOUSE_EXITED){
            timer.start();

        }
    }

}

// to use in your code, do all init and then decorate the contentPane
...
setContentPane(new JLayer(getContentPane(), new DisposingLayerUI()));