public BranchGroup getScene()
{
    BranchGroup group = new BranchGroup();

    ObjectFile object = new ObjectFile();
    Scene scene = null;

    try
    {
        scene = object.load("/Users/John/ArtOfIllusion/Hourglass.obj");
    }catch(Exception e){e.printStackTrace();}

    group.addChild(scene.getSceneGroup());

    Color3f light1Color = new Color3f(1.0f, 1.0f, 1.0f);
    BoundingSphere bounds = new BoundingSphere(new Point3d(0.0,0.0,0.0), 100.0);
    Vector3f light1Direction = new Vector3f(.3f, 0, 0);
    DirectionalLight light1 = new DirectionalLight(light1Color, light1Direction);
    light1.setInfluencingBounds(bounds);
    group.addChild(light1);

    return group;
}