public class Animation extends JPanel implements ActionListener, KeyListener{

int x = 0, y = 0, velx=0;

public Animation(){
    addKeyListener(this);
    setFocusable(true);
    setFocusTraversalKeysEnabled(false);
}

public static void main(String args[]){
    JFrame frame = new JFrame("Animation Test");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
    frame.setSize(500, 500);
    Animation a = new Animation();
    frame.add(a);
    frame.repaint();
    frame.addKeyListener(a);

}

protected void paintComponent(Graphics g){
    super.paintComponent(g);
    g.setColor(Color.BLACK);
    g.fillRect(0, 0, 500, 500);
    g.setColor(Color.RED);
    g.fillRect(x, 50, 30, 20);
 }

@Override
public void actionPerformed(ActionEvent e) {
    // TODO Auto-generated method stub
    x = x + velx;
}

@Override
public void keyTyped(KeyEvent e) {
    // TODO Auto-generated method stub

}

@Override
public void keyPressed(KeyEvent e) {
    // TODO Auto-generated method stub
    int keyCode = e.getKeyCode();
    if(keyCode == e.VK_SPACE){
        velx = 2;
        x = x + velx;
    }
    repaint();
}

@Override
public void keyReleased(KeyEvent e) {
    // TODO Auto-generated method stub

}

}