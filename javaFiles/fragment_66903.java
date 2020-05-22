SpeedRun2Game game;
...
button_stats.addListener(new ClickListener(){
    @Override
    public void clicked(InputEvent event, float x, float y){

        stage.addAction(Actions.sequence(Actions.fadeOut(0.2f), Actions.run(new Runnable(){
            @Override
            public void run() {
                game.setScreen(new StatsScreen(game));
                }
        })));
    }
});