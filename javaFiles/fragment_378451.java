int redColor,greenColor,blueColor;
 for ( int i=0 ; i<triangle.size() ; i++) {
        Triangle tri;
        tri=triangle.get(i);
        redColor=(int)(Math.random()*255);
        greenColor=(int)(Math.random()*255);
        blueColor=(int)(Math.random()*255);
        g2.setColor(new Color(redColor,greenColor,blueColor));
        tri.draw(g2);
 }