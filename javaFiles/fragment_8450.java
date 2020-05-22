public static void main(String[] arg) {
        final LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        new LwjglApplication(new YourGame(new Callback() {
            @Override
            public void setForegroundFPS(int foregroundFPS) {
                config.foregroundFPS = foregroundFPS;
            }

            @Override
            public void setBackgroundFPS(int backgroundFPS) {
                config.backgroundFPS = backgroundFPS;
            }
        }), config);
    }