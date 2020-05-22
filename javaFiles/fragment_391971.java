public void render() {

    BufferStrategy bs = this.getBufferStrategy();
    if(bs == null)
    {
        createBufferStrategy(3); //Use 5 at most
        return;
    }
    Graphics g = bs.getDrawGraphics();

    //RENDER HERE
    // Paint background here...
    player.render(g);
    healthBars.render(g);



    //END RENDER
    g.dispose();
    bs.show();
}