public enum GameScreen{
        MENU_SCREEN{

            @Override
            public void render(MyGdxGame gdxGame) {

            }
        }, GAME_SCREEN{

            @Override
            public void render(MyGdxGame gdxGame) {

            }

        }, LEVELSCREEN{

            @Override
            public void render(MyGdxGame gdxGame) {

            }
        };

        public abstract void render(MyGdxGame gdxGame);
    }