public void move(int distance) {
    int endPosition = this.position + distance;
    if (MIN_POSITION > endPosition || MAX_POSITION < endPosition) {
        throw new IllegalPositionException("Invalid end position: " + endPosition + " when moved by " + distance);
    }
    this.setPosition(endPosition);
}