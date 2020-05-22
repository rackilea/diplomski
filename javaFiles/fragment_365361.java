public class MyFrame extends JFrame {
    private JLabel jLab;
    //...fields, getters, setters whatever...
    private int i;
    public MyFrame()
    {
        i = 0;
        jLab = new JLabel("Example");
        addKeyListener(new KeyListener() {
            @Override
            public void keyPressed(KeyEvent ke) {
                //doSomething(); - this may create confusion.
            }
            @Override
            public void keyReleased(KeyEvent ke) {
                //doSomething(); - this may create confusion.
            }
            @Override
            public void keyTyped(KeyEvent ke) {
                doSomething();
            }
        });
        add(jLab);
        pack();
        setVisible(true);
    }

    private void doSomething() {
        i++;
        jLab.setText(i + "");
    }
}