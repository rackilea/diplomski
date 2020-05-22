frame.addComponentListener( new ComponentAdapter() {
    @Override
    public void componentResized( ComponentEvent e ) {
        panel.setLocation(button.getX() - button.getWidth() - 10, button.getY());
    }
} );