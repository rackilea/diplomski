HashMap<Integer, Color> colorsMap = new HashMap<>();
int selectedColor = Color.BLUE;
public test() {
    ....
    colorsMap.put(KeyEvent.VK_B, Color.BLUE);
    colorsMap.put(KeyEvent.VK_R, Color.RED);
    colorsMap.put(KeyEvent.VK_Y, Color.YELLOW);
    colorsMap.put(KeyEvent.VK_G, Color.GREEN);
    ....
}

public void drawRectangle(Graphics g, int x, int y) {
    g.setColor(selectedColor);
    g.fillRect(x, y, 2, 2);
}
@Override
public void paint(Graphics g) {
    ....
    drawRectangle(g, x, y);
    ....
}
public void keyPressed(KeyEvent e) {
    if(colorsMap.containsKey(e.getKeyCode())){
        selectedColor = colorsMap.get(e.getKeyCode());
    }
}