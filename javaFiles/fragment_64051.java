loader1 = new RubeSceneLoader();
scene1 = loader1.loadScene(Gdx.files.internal("XXXX.json"));
World mWorld1 = scene1.getWorld();

RubeWorldSerializer.mergeWorld = mWorld1; // this is important in between your loading.

loader2 = new RubeSceneLoader();
scene2 = loader2.loadScene(Gdx.files.internal("ABCD.json"));
World mWorld2 = scene2.getWorld(); // in theory mWorld2 should be the same like mWorld1 now, and it should be both worlds merged