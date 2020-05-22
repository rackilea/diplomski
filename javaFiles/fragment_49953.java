@Override
public void keyPressed(KeyEvent e){
    if(e.getKeyCode == 65){
        aPressed = true;
    }
}

@Override
public void keyReleased(KeyEvent e){
    if(e.getKeyCode == 65){
        aPressed = false;
    }
}