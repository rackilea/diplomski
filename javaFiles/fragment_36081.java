public void init(){

    setSize(700, 500);
    addKeyListener(this);

    player = new Player(100, 100);
    hud = new HUD();
    // Notice that HUD has not been re-declared...

    for (int i = 0; i < 75; i++){

        new Grass(i*30, 400);

    }
    new Spikes(250, 370);

}