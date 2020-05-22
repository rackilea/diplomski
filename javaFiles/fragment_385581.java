public Classname(){
    //stuff
    window.addKeyListener(new KeyAdapter(){
//For every time the specific key is being pressed
        public void keyPressed(KeyEvent e){
            KeyCode = e.getKeyCode();
                switch (KeyCode) {
                case KeyEvent.VK_SPACE: 
                    //stuff
                    break;
                case KeyEvent.VK_H:
                    //stuff
                    break;

                }
            }
        }
//For every time the specific key is being released
public void keyReleased(KeyEvent e){
            switch (e.getKeyCode()) {
            case KeyEvent.VK_LEFT: //stuff
 break;
            case KeyEvent.VK_RIGHT: //stuff
   break;

        }
    });

}