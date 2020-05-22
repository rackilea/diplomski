public class Test2 extends JFrame {

    private boolean $isPressed; /*
                                 * To check if we already listened to a key
                                 * press event
                                 */

    /**
     * Constructor to make a new quiz
     */
    public Test2() {

        this.setTitle("");

        $isPressed = false;

        setFocusable(true);
        getContentPane().setLayout(new BorderLayout());
        JButton b = new JButton();
        b.addFocusListener(new FocusListener() {

            @Override
            public void focusLost(FocusEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void focusGained(FocusEvent e) {
                Test2.this.requestFocus();
            }
        });
        getContentPane().add(b);
        /* Add a keylistener for every team */
        addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {

                System.out.println("TEST");
            }
        });
        $isPressed = false;
        b.grabFocus();
        pack();
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        new Test2().setVisible(true);

    }
}