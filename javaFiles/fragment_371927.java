public class KeyFrame extends JFrame implements KeyListener
{
    public boolean t = true;
    private final HashSet<Integer> pressed = new HashSet<Integer>();

    private Timer timer;
    public KeyFrame(String name) {
        super(name);

        new Timer(10, new ActionListener(){
            public void actionPerformed(ActionEvent arg0){
                if(pressed.contains(KeyEvent.VK_D)) {
                    setSize(getWidth()+5, getHeight());
                } else if(pressed.contains(KeyEvent.VK_A)) {
                    setSize(getWidth()-5, getHeight());
                } else if(pressed.contains(KeyEvent.VK_S)) {
                    setSize(getWidth(), getHeight()+5);
                } else if(pressed.contains(KeyEvent.VK_W)) {
                    setSize(getWidth(), getHeight()-5);
                }
            }
        }).start(); 
     }

    public void keyTyped(KeyEvent e) {
        return;
    }

    public void keyPressed(KeyEvent e) {
        pressed.add(e.getKeyCode());
    }

    public void keyReleased(KeyEvent e) {
        pressed.remove(e.getKeyCode());
    }
}