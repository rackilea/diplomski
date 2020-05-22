public class CoreClass extends Game {


Array<Body> bodies = new Array<Body>();
World world = new World(new Vector2(0.0f, 0.0f), true);

Body bodyRed;
Body bodyGreen;
private float prevX;
private float prevY;

@Override
public void create() {
    BodyDef bodyBD = new BodyDef();
    bodyBD.type = BodyType.DynamicBody;

    FixtureDef bodyFD = new FixtureDef();
    bodyFD.density = 1.0f;
    bodyFD.friction = 1.0f;
    bodyFD.restitution = 1.0f;

    bodyRed = world.createBody(bodyBD);
    bodyGreen = world.createBody(bodyBD);

    bodyRed.createFixture(bodyFD);
    bodyGreen.createFixture(bodyFD);

    prevX = bodyGreen.getPosition().x; prevY = bodyGreen.getPosition().y;

    world.setContactListener(new ContactListener() {

        @Override
        public void beginContact(Contact contact) {
            world.getBodies(bodies);
            bodies.get(contact.getChildIndexA()).getPosition().set(prevX, prevY);
        }

        @Override
        public void endContact(Contact contact) {

        }

        @Override
        public void preSolve(Contact contact, Manifold oldManifold) {

        }

        @Override
        public void postSolve(Contact contact, ContactImpulse impulse) {

        }

    });
}

@Override
public void render() {
    super.render();
    prevX = bodyGreen.getPosition().x;
    prevY = bodyGreen.getPosition().y;
    world.step(1/45f, 2, 6);
}