public class MyContactListener implements ContactListener{
@Override
public void beginContact(Contact contact) {
    Fixture fa = contact.getFixtureA();
    Fixture fb = contact.getFixtureB();
    if(fa == null || fb == null) return;
    // ...
}

@Override
public void endContact(Contact contact) {
    Fixture fa = contact.getFixtureA();
    Fixture fb = contact.getFixtureB();
    if(fa == null || fb == null) return;
    // ...
}

@Override
public void preSolve(Contact contact, Manifold oldManifold) {}
@Override
public void postSolve(Contact contact, ContactImpulse impulse) {}

}