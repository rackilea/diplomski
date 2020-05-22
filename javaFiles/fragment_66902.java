button_stats.addListener(new ClickListener(){
    @Override
    public void clicked(InputEvent event, float x, float y){
         ScreenManager.getInstance().showScreen(ScreenEnum.STATS);
    }
});