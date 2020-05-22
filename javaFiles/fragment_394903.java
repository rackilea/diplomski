LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
cfg.title = "MyGame";
cfg.useGL20 = false;
cfg.width = 480;
cfg.height = 320;

...
new LwjglApplication(new UserStart(userID, appDefinitions), cfg);