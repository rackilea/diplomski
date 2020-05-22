if (gameHelper == null) {
        gameHelper = new GameHelper(this, GameHelper.CLIENT_ALL); //maybie CLIENT_GAMES?
        gameHelper.enableDebugLog(true);
    }
    gameHelper.setup(this);

    AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();
    initialize(new LIBGDXGAME(this), config)