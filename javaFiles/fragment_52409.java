this.grid[i][j].addListener(new ClickListener(){
        @Override
        public void clicked(InputEvent event, float x, float y){
           System.out.println(event.getListenerActor().getName());
        }
    });