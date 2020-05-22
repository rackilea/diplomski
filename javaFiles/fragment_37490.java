public static class ShapePane extends JPanel {

    public enum ShapeType {

        CIRCLE,
        RECTANGLE
    }

    private ShapeType currentShapeType;

    public ShapePane() {
        addMouseListener(new MouseAdapter() {

            private Point clickPoint;

            @Override
            public void mousePressed(MouseEvent e) {
                clickPoint = e.getPoint();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                Point releasePoint = e.getPoint();
                int x = Math.min(releasePoint.x, clickPoint.x);
                int y = Math.min(releasePoint.y, clickPoint.y);
                int width = Math.abs(clickPoint.x - releasePoint.x);
                int height = Math.abs(clickPoint.y - releasePoint.y);
                switch (getCurrentShapeType()) {
                    case CIRCLE:
                        // Make a circle
                        break;
                    case RECTANGLE:
                        // Make a rectangle...
                        break;
                }
                repaint();
            }

        });
    }

    public void setCurrentShapeType(ShapeType currentShapeType) {
        this.currentShapeType = currentShapeType;
    }

    public ShapeType getCurrentShapeType() {
        return currentShapeType;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Custom Painting here...
    }

}