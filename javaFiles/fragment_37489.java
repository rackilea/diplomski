public static class ShapePane extends JPanel {

    public enum ShapeType {

        CIRCLE,
        RECTANGLE
    }

    private ShapeType currentShapeType;

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