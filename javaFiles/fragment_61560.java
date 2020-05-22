public void init(GameContainer gc, StateBasedGame game) throws SlickException{
    try{
        theme[0] = new Music("path/to/theme1.ogg",true);
    }catch (Exception e){
        e.printStackTrace;
    }
}