MathTransform transform = CRS.findMathTransform(epsg4326, targetWKT, true);

        DirectPosition2D srcDirectPosition2D
                = new DirectPosition2D(epsg4326, latitude, longitude);
        DirectPosition2D destDirectPosition2D
                = new DirectPosition2D();
        transform.transform(srcDirectPosition2D, destDirectPosition2D);

        double transX = destDirectPosition2D.x;
        double transY = destDirectPosition2D.y;

        int kmPerPixel = mapImage.getWidth / 1024; // It is known to me that my map is 1024x1024km ...

        double x = zeroPointX + ( (transX * 0.001) * kmPerPixel);
        double y = zeroPointY + ( ( (transX * -1) * 0.001) * kmPerPixel);