BulletAppState buleltAppState;

public void simpleInitApp() {

    Quad q= new Quad(100, 100);
    Dome mesh = new Dome(Vector3f.ZERO, 2, 32, 1f,false);

    geom = new Geometry("Cylinder", mesh); //declared elsewhere

    g3 = new Geometry("lel", q);
    Material mat = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
    mat.setColor("Color", ColorRGBA.Blue);
    Material mat2 = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
    mat2.setColor("Color", ColorRGBA.Red);
    geom.setMaterial(mat);

    g3.setMaterial(mat2);

    bulletAppState = new BulletAppState();
    stateManager.attach(bulletAppState);
    bulletAppState.getPhysicsSpace().attachChild(geom);
    bulletAppState.getPhysicsSpace().attachChild(g3);

    rootNode.attachChild(geom);
    rootNode.attachChild(g3);
}