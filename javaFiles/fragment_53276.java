GeneralPath polygon = 
    new GeneralPath(GeneralPath.WIND_EVEN_ODD, 4);
polygon.moveTo(2.0, 1.0);
polygon.lineTo(2.0, 5.0);
polygon.quadTo(1.25, 4.75, 1.0, 4.0);
polygon.lineTo(1.0, 2.0);
polygon.quadTo(1.75, 1.75, 2.0, 1.0);
polygon.closePath();
g.draw(polygon);