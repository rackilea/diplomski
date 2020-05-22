boolean clicked = false;

public void paintComponent(Graphics g) {
    if (clicked) {
        g.setColor(Color.blue);
        g.drawRect(10, 10, 80, 30);
    }
}

public void actionPerformed(ActionEvent e){
    clicked = true;
    repaint();
}