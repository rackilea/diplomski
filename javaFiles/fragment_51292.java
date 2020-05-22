button.addListener(new ClickListener() {
        @Override
        public void enter(InputEvent event, float x, float y, int pointer, Actor fromActor) {
            super.enter(event, x, y, pointer, fromActor);

            if (fromActor != null)
                fromActor.setSize(overSize, overSize);
        }
        @Override
        public void exit(InputEvent event, float x, float y, int pointer, Actor toActor) {
            super.exit(event, x, y, pointer, toActor);

            if (toActor != null)
                toActor.setSize(defaultSize, defaultSize);
        }
    });