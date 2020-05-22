Environment environment;
DirectionalShadowLight shadowLight;

@Override
public void show() {
    modelBatch = new ModelBatch(); 
    environment = new Environment();
    environment.set(new ColorAttribute(ColorAttribute.AmbientLight, 1.0f, 1f, .6f, 1f));
    environment.add((shadowLight = new DirectionalShadowLight(1024, 1024, 60f, 60f, .1f, 50f))                  
                .set(1f, 1f, 1f, 40.0f, -35f, -35f));   
    environment.shadowMap = shadowLight; 

    shadowBatch = new ModelBatch(new DepthShaderProvider());
}

@Override
public void render(float delta) {
        //create shadow texture
        shadowLight.begin(Vector3.Zero, camera.direction);
        shadowBatch.begin(shadowLight.getCamera());

        shadowBatch.render(instances);

        shadowBatch.end();
        shadowLight.end();

        //render scene
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);


        modelBatch.begin(cam);      
        modelBatch.render(instances, environment);  //environment has shadowMap!
        modelBatch.end();
}