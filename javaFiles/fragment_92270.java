public class RenderingSystem extends IteratingSystem {

    public static final Family MONSTERS = Family.all(BoxComponent.class).get();
    //Assumes you've made a BoxComponent class

    private ShapeRenderer shapes;
    private Camera camera;

    public RenderingSystem(Camera camera) {
        super(MONSTERS);
        this.camera = camera;
        this.shapes = new ShapeRenderer();
    }

    @Override
    public void update(float deltaTime) {
        shapes.begin(ShapeType.Line);
        shapes.setColor(Color.RED);
        super.update(deltaTime);
        shapes.end();
    }

    @Override
    protected void processEntity(Entity entity, float deltaTime) {
        Rectangle box = entity.getComponent(BoxComponent.class);
        // ^ Could be done faster using ComponentMappers
        shapes.rect(box.x, box.y, box.width, box.height);
    }

}