frame.addKeyListener(new KeyListener() {

        @Override
        public void keyPressed(KeyEvent arg0) {
            // TODO Auto-generated method stub
            if(arg0.isShiftDown()) {
                frame.addMouseWheelListener(new MouseWheelListener() {

                    @Override
                    public void mouseWheelMoved(MouseWheelEvent arg0) {
                        // TODO Auto-generated method stub
                        pane.getVerticalScrollBar().setValue(pane.getVerticalScrollBar().getValue()+arg0.getWheelRotation());
                    }

                });
            }
            if(!arg0.isShiftDown()) {
                frame.removeMouseWheelListener(frame.getMouseWheelListeners()[0]);
            }
        }
}