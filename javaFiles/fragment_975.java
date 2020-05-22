StaticShader shader;// = new StaticShader();

public Main() {
    Time.startTime();   

    DisplayManager.createDisplay(1200, 840, "Evolve", "v0.2");
    System.out.println(DisplayManager.getWidth() + " " + DisplayManager.getHeight());

    shader = new StaticShader();  //<--- like this

    camera = new Camera(new Vector3f(0, 0, 0));
    camera.setPerspectiveProjection(70.0f, 0.1f, 1000.0f);

    Util.glDepthCull(true);
    Util.initGL();          
}