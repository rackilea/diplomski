InputListener il = new InputListener(){
        @Override
        public boolean keyDown(InputEvent event, int keycode) {
                typeArea.append(Keys.toString(keycode));
            return super.keyDown(event, keycode);
        }
    };