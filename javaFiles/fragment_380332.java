public class Game extends JFrame implements KeyListener{
    public static int ppx,ppy;

    public Game(String string) {
        addKeyListener(this);
        // TODO Auto-generated constructor stub
    }

    public static void main(String[] args) {
        Game frame = new Game("Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,600);
        frame.add(new THIng());

        frame.setVisible(true);

    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keycode = e.getKeyCode();
        if(keycode == KeyEvent.VK_D){
            System.out.println("Debug");
        }
    }

    @Override
    public void keyReleased(KeyEvent arg0) {
        // TODO Auto-generated method stub

    }



}