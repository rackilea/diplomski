public class Test extends Game {
    private final FPSLogger fpsLogger = new FPSLogger();
    private ShaderProgram shader;
    private Mesh mesh;
    Matrix4 projection = new Matrix4();
    Matrix4 view = new Matrix4();
    Matrix4 model = new Matrix4();
    Matrix4 combined = new Matrix4();
    Matrix4 modelView = new Matrix4();
    Matrix3 normalMatrix = new Matrix3();
    Vector3 axis = new Vector3(1, 0, 1).nor();
    float angle = 45;

    private static final float[] light = { 20, 20, 20 };

    private static final float[] amb = { 0.2f, 0.2f, 0.2f, 1.0f };
    private static final float[] dif = { 0.5f, 0.5f, 0.5f, 1.0f };
    private static final float[] spec = { 0.7f, 0.7f, 0.7f, 1.0f };

    public Test() {}

    @Override public void create() {
        this.mesh = Shapes.genCube();
        ShaderProgram.pedantic = false;
        final String location = "shaders/phong";
        this.shader = new ShaderProgram(Gdx.files.internal(location + ".vsh").readString(), Gdx.files.internal(location + ".fsh").readString());
        if (!this.shader.isCompiled()) {
            Gdx.app.log("Problem loading shader:", this.shader.getLog());
        }

        Gdx.gl20.glEnable(GL20.GL_DEPTH_TEST);
    }

    @Override public void render() {
        super.render();
        this.fpsLogger.log();

        this.angle += Gdx.graphics.getDeltaTime() * 40.0f;
        final float aspect = Gdx.graphics.getWidth() / (float) Gdx.graphics.getHeight();
        this.projection.setToProjection(1.0f, 20.0f, 60.0f, aspect);
        this.view.idt().trn(0, 0, -2.0f);
        this.model.setToRotation(this.axis, this.angle);
        this.combined.set(this.projection).mul(this.view).mul(this.model);
        this.modelView.set(this.view).mul(this.model);

        Gdx.gl20.glViewport(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        Gdx.gl20.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);
        this.shader.begin();

        this.shader.setUniformMatrix("mvpMatrix", this.combined);
        this.shader.setUniformMatrix("mvMatrix", this.modelView);
        this.shader.setUniformMatrix("normalMatrix", this.normalMatrix.set(this.modelView).inv().transpose());
        this.shader.setUniform4fv("ambientColor", amb, 0, 4);
        this.shader.setUniform4fv("diffuseColor", dif, 0, 4);
        this.shader.setUniform4fv("specularColor", spec, 0, 4);
        this.shader.setUniform3fv("vLightPosition", light, 0, 3);

        this.mesh.render(this.shader, GL20.GL_TRIANGLES);

        this.shader.end();
    }

    @Override public void dispose() {
        if (this.mesh != null) {
            this.mesh.dispose();
        }
        if (this.shader != null) {
            this.shader.dispose();
        }
    }
}