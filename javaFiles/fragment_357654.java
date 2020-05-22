int createdCircles = 0;
outer: while (createdCircles < 25) {
    Circle candidate = new Circle(...);
    inner: for (int z = 0; ...) {
        if (detectCollision(...)) continue outer;
    }
    circles[createdCircles] = candidate;
    createdCircles++;
}