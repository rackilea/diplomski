protected void captureDepth() {
        fbo.begin();
        Gdx.gl.glClearColor(1.0f, 1.0f, 1.0f, 0.0f);
        Gdx.gl.glClear(GL20.GL_DEPTH_BUFFER_BIT | GL20.GL_COLOR_BUFFER_BIT);
        depthBatch.begin(camera);
        depthBatch.render(instances);
        depthBatch.end();
        fbo.end();
    }