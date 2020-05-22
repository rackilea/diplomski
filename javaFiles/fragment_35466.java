int x = 0;
int increment = 10;
baby.setColor(new Color(16,15,15));
while ( x < 1000 ){
    x += increment;
    baby.drawLine(x, 0, x, 1000);
}