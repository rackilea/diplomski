@Override
public void mousePressed(java.awt.event.MouseEvent e) {
    Component component = e.getComponent();
    Component source = component.getComponentAt(e.getPoint());
    for (int i = 0; i < size; i++) {
        for (int j = 0; j < size; j++) {
            if (source == squares[i][j]) {
                if (litSquares[i][j] == false) {
                    squares[i][j].setBackground(selected);
                    litSquares[i][j] = true;
                } else {
                    squares[i][j].setBackground(backGround);
                    litSquares[i][j] = false;
                }
            }
        }
    }
}