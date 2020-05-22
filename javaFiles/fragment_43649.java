Gdx.input.setInputProcessor(new GestureDetector(new GestureAdapter(){
        @Override
        public boolean tap(float x, float y, int count, int button) {

             //here you can write code for touch event.
              return true;
        }

    }));