private Screen screen;

public Kingdomcraft() {
    EventQueue.invokeLater(new Runnable() {
        @Override
        public void run() {
            screen = new Screen(Kingdomcraft.this);
        }
    });
}

//...

public static void main(String[] args) {

    Kingdomcraft kd = new Kingdomcraft();
    // This does nothing...
    //Screen screen = new Screen();
    kd.start();
    //screen.run();

}