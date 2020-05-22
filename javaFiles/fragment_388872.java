double width = getWidth();
        double height = getHeight();

        double zoomWidth = width * zoom;
        double zoomHeight = height * zoom;

        double anchorx = (width - zoomWidth) / 2;
        double anchory = (height - zoomHeight) / 2;

        AffineTransform at = new AffineTransform();
        at.translate(anchorx, anchory);
        at.scale(zoom, zoom);
        at.translate(-100, -100);