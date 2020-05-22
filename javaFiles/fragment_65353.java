class BasicComboPopup extends ... {

    private Handler getHandler() {
        if (handler == null) {
            handler = new Handler();
        }
        return handler;
    }

    private class Handler implements ... MouseListener ... {

        public void mouseReleased(MouseEvent e) {
            //...
            Component source = (Component)e.getSource();
            Dimension size = source.getSize();
            Rectangle bounds = new Rectangle( 0, 0, size.width - 1, size.height - 1 );
            if ( !bounds.contains( e.getPoint() ) ) {
                //...
                comboBox.setPopupVisible(false);
            }
        }
    }
}