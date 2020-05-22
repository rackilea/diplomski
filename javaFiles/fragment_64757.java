// Set of currently pressed keys
private final Set<Integer> pressed = new TreeSet<Integer>();

@Override
public void keyPressed(KeyEvent arg0) {
    int c = arg0.getKeyCode();
    pressed.add(c);
    if (pressed.size() > 1) {
        Integer[] array = pressed.toArray(new Integer[] {});
        if (array[0] == KeyEvent.VK_LEFT && array[1] == KeyEvent.VK_UP) {
            velx = -4;
            vely = -4;
        } else if (array[0] == KeyEvent.VK_UP && array[1] == KeyEvent.VK_RIGHT) {
            velx = 4;
            vely = 4;
        } else if (array[0] == KeyEvent.VK_RIGHT && array[1] == KeyEvent.VK_DOWN) {
            velx = 4;
            vely = -4;
        } else if (array[0] == KeyEvent.VK_LEFT && array[1] == KeyEvent.VK_DOWN) {
            velx = -4;
            vely = 4;
        }
    } else {
        if (c == KeyEvent.VK_LEFT) {
            velx = -4;
            vely = 0;
        } else if (c == KeyEvent.VK_RIGHT) {
            velx = 4;
            vely = 0;
        } else if (c == KeyEvent.VK_UP) {
            velx = 0;
            vely = -4;
        } else if (c == KeyEvent.VK_DOWN) {
            velx = 0;
            vely = 4;
        }
    }

}

@Override
public void keyReleased(KeyEvent arg0) {
    velx = 0;
    vely = 0;

    pressed.remove(Integer.valueOf(arg0.getKeyCode()));
}