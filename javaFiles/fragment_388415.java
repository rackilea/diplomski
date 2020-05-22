public static void main(String[] args) {

    Sc sc = new Sc();
    MainClass mc = new MainClass();
    mc.fun(sc);
    sc.initFrame();

}

public void initFrame() {
    JFrame frame = new JFrame();
    frame.getContentPane().add(this);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(200, 200);
    frame.setVisible(true);
}