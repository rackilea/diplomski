PDRectangle mediabox = page.findMediaBox();
        float margin = 72;
        float width = mediabox.getWidth() - 2 * margin;
        float startX = mediabox.getLowerLeftX() + margin;
        float startY = mediabox.getUpperRightY() - margin;
        float heightCounter = startY;