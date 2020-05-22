class MyPanel extends JPanel {

    private Timer t1,t2...;

    //this method will terminate the game i.e timers gameloop music etc
    void destroy() {
       t1.stop();
       t2.stop();
    }

}