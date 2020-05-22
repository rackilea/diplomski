public class OnKeyAltF4DontClose2 extends JFrame {//implements  WindowListener {

public OnKeyAltF4DontClose2() {
    setVisible(true);
    setDefaultCloseOperation(3);
    setBounds(400,400,400,400);



    addKeyListener(new KeyAdapter(){
        public void keyPressed(KeyEvent e) {

            if(((KeyStroke.getKeyStroke(KeyEvent.VK_SPACE, java.awt.event.InputEvent.ALT_DOWN_MASK)) != null)  &&  e.getKeyCode() == KeyEvent.VK_F4){

            e.consume();
            }

            }

    });

}
public static void main(String[] args) {
    new OnKeyAltF4DontClose2();

}