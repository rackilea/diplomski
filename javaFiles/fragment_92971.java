public void simpleInitApp() {
    BulletAppState state = new BulletAppState();
    getStateManager().attach(state);

    PhysicsSpace space = state.getPhysicsSpace();
    space.addCollisionListener(new PhysicsCollisionListener()
    {
        public void collision(PhysicsCollisionEvent event) {
            // Same code but without bulletAppState.getPhysicsSpace().remove()
        }
    });

    Material mat = new Material(getAssetManager(), "Common/MatDefs/Misc/ShowNormals.j3md");
    CollisionShape collisionShape = new BoxCollisionShape(new Vector3f(5, 5, 5));

    ProjectileCollisionControl ctrlA = new ProjectileCollisionControl(collisionShape);
    Box a = new Box(new Vector3f(0.4f, 0, 0), 1, 1, 1);
    Geometry boxGeomA = new Geometry("Box A", a);
    boxGeomA.setMaterial(mat);
    boxGeomA.addControl(ctrlA);

    ProjectileCollisionControl ctrlB = new ProjectileCollisionControl(collisionShape);
    Box b = new Box(new Vector3f(-0.4f, 0, 0), 1, 1, 1);
    Geometry boxGeomB = new Geometry("Box B", b);
    boxGeomB.setMaterial(mat);
    boxGeomB.addControl(ctrlB);

    getRootNode().attachChild(boxGeomA);
    getRootNode().attachChild(boxGeomB);
    space.add(ctrlA);
    space.add(ctrlB);
    space.addTickListener(ctrlA);
    space.addTickListener(ctrlB);
}