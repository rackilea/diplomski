public void keyPressed(KeyEvent e) {
    System.out.println("KeyEvent: "+e);
    int key = e.getKeyCode();

    if(key == KeyEvent.VK_LEFT) {
        velocityOfCharacter = -5;
    }
    else if(key == KeyEvent.VK_RIGHT) {
        velocityOfCharacter = 5;
    }
    xAxisOfCharacter += velocityOfCharacter;
}