final Point p1 = new Point();
p1.x=(int) x; //x co-ordinate where the user touches on the screen
p1.y=(int) y; //y co-ordinate where the user touches on the screen  

FloodFill f= new FloodFill(); 
f.floodFill(bmp,pt,targetColor,replacementColor);