TextButtonStyle style = new TextButtonStyle();
    style.font = new BitmapFont();
    style.font.setColor(Color.WHITE);

    continue= new TextButton("continue",
            style);

    continue.addListener(new ClickListener() {
        @Override
        public void clicked(InputEvent event, float x, float y) {
             if(manager.update()){ //returns true if the AssetManager is done in case you use an AssetManager
                  basegameclass.setScreen("menu"); //sets the menu screen
             }else{
             //not done do nothing or do something else like showing loading not done
             }
        }
    });