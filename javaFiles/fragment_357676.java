int x = 1; //x starts a little to the right of 0
int y = 0; //y starts at 0
while (x > 0 && y > 0){
    if (x < panel.getWidth() && y == 0){
        panel.drawNextPixel(x, y);
        x++;
    }
    else if (x == panel.getWidth() && y != panel.getHeight()){
        panel.drawNextPixel(x, y);
        y++;
    }
    else if (x > 0 && y == panel.getHeight()){
        panel.drawNextPixel(x, y);
        x--;
    }
    else {
        panel.drawNextPixel(x, y);
        y--;
    }
}