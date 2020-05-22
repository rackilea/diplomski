private class ColouredLine extends Line {
    private Color color;
    public ColouredLine(Line line, Color color) {
        super (line);
        this.color = color;
    }

}