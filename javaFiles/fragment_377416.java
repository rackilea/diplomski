double b = width / Math.tan(Math.toRadians(angle));

        Path2D triangle = new Path2D.Double();
        triangle.moveTo(10, height - 20);
        triangle.lineTo(10, height - 20 - b);

        triangle.lineTo(width - 20, height - 20);
        triangle.closePath();