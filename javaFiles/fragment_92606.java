else if (getCursorState() == RESIZING) {
    Point startPoint = null;
    Point endPoint = null;

    switch(getCursor().getType()) {
        case Cursor.SW_RESIZE_CURSOR:
            startPoint = new Point((int) mouse.getX(), (int) rectangle.getMinY());
            endPoint = new Point((int) rectangle.getMaxX(), (int) mouse.getY());
            break;
        case Cursor.NW_RESIZE_CURSOR:
            startPoint = new Point((int) mouse.getX(), (int) mouse.getY());
            endPoint = new Point((int) rectangle.getMaxX(), (int) rectangle.getMaxY());
            break;
        case Cursor.NE_RESIZE_CURSOR:
            startPoint = new Point((int) rectangle.getMinX(), (int) mouse.getY());
            endPoint = new Point((int) mouse.getX(), (int) rectangle.getMaxY());
            break;
        case Cursor.SE_RESIZE_CURSOR:
            startPoint = new Point((int) rectangle.getMinX(), (int) rectangle.getMinY());
            endPoint = new Point((int) mouse.getX(), (int) mouse.getY());
            break;
    }

    rectangle.setFrameFromDiagonal(startPoint, endPoint);    

    if (fixedRatio) {
        // Calculate 3:4 aspect ratio
        rectangle.height = rectangle.width / 3 * 4;

        // If this is a NW or NE resize, we need to adjust the start y coordinate to account for the new height
        // This keeps the bottom right corner in the same place for a NW resize
        // and the bottom left corner in the same place for a NE resize
        if (getCursor().getType() == Cursor.NW_RESIZE_CURSOR || getCursor().getType() == Cursor.NE_RESIZE_CURSOR) {
            rectangle.y = endPoint.y - rectangle.height;
        }
    }
}