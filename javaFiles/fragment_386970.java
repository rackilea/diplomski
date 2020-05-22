class Trail {
    private final int maxLength;

    private float[] points;
    private int start = 0;
    private int length = 0;

    private float[] buffer;

    public Trail(int maxLength) {
        this.maxLength = maxLength;
        this.points = new float[maxLength];
        this.buffer = new float[0];
    }

    public void add(float point) {
        points[(start + length) % points.length] = point;
        if (length < maxLength) {
            length++;
        } else {
            start = (start + 1) % points.length;
        }
    }

    public float[] getTail() {
        if (buffer.length != length) { // Reusing the array if possible.
            buffer = new float[length];
        }
        int itemsFromStartToArrayEnd = Math.min(length, points.length - start);
        System.arraycopy(points, start, buffer, 0, itemsFromStartToArrayEnd);
        if (start + length > maxLength) {
            System.arraycopy(points, 0, buffer, itemsFromStartToArrayEnd, length - itemsFromStartToArrayEnd);
        }
        return buffer;
    }
}