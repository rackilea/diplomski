public void move() {
    x += speed * Math.cos(Math.toRadians(direction));
    y += speed * Math.sin(Math.toRadians(direction));
}

@Override
public void keyPressed(KeyEvent e) {
    int key = e.getKeyCode();
    if(key == KeyEvent.VK_LEFT){
        turn(-.6);
        //this is meant to turn the player int a clockwise direction by 0.6
    } else if (key == KeyEvent.VK_RIGHT){
        turn(.6);
        //counterclockwise by 0.6
    }
   .....//rest of code}

private void turn(double degrees) {
    direction += degrees;
    if(direction > 180) direction = 180;
    else if(direction < 180) direction = 0;
    }