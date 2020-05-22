public void start() {                                       //running = true
    running = true;
    new Thread(this).start();
    menu = true;
    RENDER();
}