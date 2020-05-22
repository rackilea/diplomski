if(animationFinished()) {
         loadAssets();
         JsonLevel.loadLevels();
         lvl = JsonLevel.levels.get(currentLevel);
         gameMain.setScreen(new PlayScreen(gameMain, lvl, currentLevel));
    }