public void init(){

    setSize(700, 500);
    addKeyListener(this);

}

public void start(){

    player = new Player(100, 100);
    HUD hud = new HUD();

    for (int i = 0; i < 75; i++){

        new Grass(i*30, 400);

    }
    new Spikes(250, 370);


    Thread thread = new Thread(this);
    thread.start();

}