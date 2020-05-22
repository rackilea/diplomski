class MainGame{
    GameState state;

    public MainGame(){
        state = new HumanVsHumanState();
    }
    public void update(){
        state.update();
    } 
    //etc...
}