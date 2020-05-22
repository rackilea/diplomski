public void start() {                                       //running = true
    new Thread(this).start();
    running = true;
    menu = true;
    RENDER();
}