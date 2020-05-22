public boolean action(Event evt, Object arg) {
    if(evt.target instanceof MenuItem) {
        String text=(String)arg;
        System.out.println("Selected="+arg);
        if(text.equals("Exit")) {
            System.exit(0);
        } else if(text.equals("New")) {
            game.newGame();
        }
    }
    return true;
}