@Override
    public void mouseClicked(MouseEvent event) {
        statusbar.setText(String.format("Clicked at %d,%d", event.getX(), event.getY()));
        remove(mousepanel);
        DrawShapes shapes = new DrawShapes();
        getContentPane().add(shapes, BorderLayout.CENTER);
        getContentPane().revalidate();
        getContentPane().repaint();
    }