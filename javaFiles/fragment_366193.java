Transformer<Integer, Paint> vertexPaint = new Transformer<Integer, Paint>() {
    private final Color[] palette = {Color.GREEN, Color.BLUE, Color.RED}; 

    public Paint transform(Integer i) {
        return palette[i.intValue() % palette.length];
    }
};