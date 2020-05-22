boolean keepPressingO = false;
public ViewPotion() {
    addKeyListener(new KeyAdapter() {
        public void keyPressed(KeyEvent event) {

            if (event.getKeyCode() == KeyEvent.VK_F4) {
                System.out.println("Iniciando AutoPotion");
                keepPressingO = true;

                new Thread() {
                    @Override
                    public void run() {
                        try {
                            while (keepPressingO) {
                                Robot robot = new Robot();
                                robot.keyPress(KeyEvent.VK_O);
                            }
                        } catch (AWTException e) {
                            e.printStackTrace();
                        }
                    }
                }.start();

            }

            if (event.getKeyCode() == KeyEvent.VK_F2) {
                System.out.println("Parando AutoPotion");
                keepPressingO = false;
            }
        }
    }); 
}