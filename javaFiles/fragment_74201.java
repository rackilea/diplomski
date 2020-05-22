stage.addListener(new ClickListener(){
        @Override
        public void clicked(InputEvent event, float x, float y) {

            //check if box is hit
            if (pop.equals(stage.hit(x, y, false))) {
                //box hit
            } else {
                //box was not hit
            }

        }
    });