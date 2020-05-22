public void update(Dimension bounds, Point mousePoint) {

    PathIterator pathIterator = areaOfEffect.getPathIterator(AffineTransform.getTranslateInstance(x, y));
    GeneralPath path = new GeneralPath();
    path.append(pathIterator, true);
    if (mousePoint != null && path.contains(mousePoint)) {

        // Determine which axis is closes to the cursor...
        int xDistance = Math.abs(x + (dimeter / 2) - mousePoint.x);
        int yDistance = Math.abs(y + (dimeter / 2) - mousePoint.y);

        if (xDistance < yDistance) {
            // If x is closer, the change the delatX
            if (x + (dimeter / 2) < mousePoint.x) {
                if (deltaX > 0) {
                    deltaX *= -1;
                }
            } else {
                if (deltaX > 0) {
                    deltaX *= -1;
                }
            }
        } else {
            // If y is closer, the change the deltaY
            if (y + (dimeter / 2) < mousePoint.y) {
                if (deltaY > 0) {
                    deltaY *= -1;
                }
            } else {
                if (deltaY > 0) {
                    deltaY *= -1;
                }
            }
        }

    }
    //...Rest of previous method code...
}