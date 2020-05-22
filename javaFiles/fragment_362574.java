@Override
        public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0.2f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        camera.update();
        myGame.batch.setProjectionMatrix(camera.combined);

        myGame.batch.begin();
        stage.draw();
        myGame.batch.end();
}