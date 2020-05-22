//skipped imports beause of char limit in this post
public final class energon extends JPanel {



    int s = 0, count = 0;

    public energon() {
        setLayout(new BorderLayout());
        GraphicsConfiguration gc=SimpleUniverse.getPreferredConfiguration();
        Canvas3D canvas3D = new Canvas3D(gc);
        add("Center", canvas3D);

        BranchGroup scene = createSceneGraph();
        scene.compile();

        // SimpleUniverse is a Convenience Utility class
        SimpleUniverse simpleU = new SimpleUniverse(canvas3D);


        // This moves the ViewPlatform back a bit so the
        // objects in the scene can be viewed.
        simpleU.getViewingPlatform().setNominalViewingTransform();

        simpleU.addBranchGraph(scene);
    }
    public BranchGroup createSceneGraph() {
        BranchGroup lineGroup = new BranchGroup();
        Appearance app = new Appearance();
        ColoringAttributes ca = new ColoringAttributes(new Color3f(204.0f, 204.0f,204.0f), ColoringAttributes.SHADE_FLAT);
        app.setColoringAttributes(ca);
        Point3f[] plaPts = new Point3f[5];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j <2; j++) {
                plaPts[count] = new Point3f(i/10.0f,j/10.0f,0);
                count++;
            }
        }
        plaPts[count] = new Point3f(3.0f/10.0f,2.0f/10.0f,0);
        int[]intArr=new int[5];
        intArr[0]=3;intArr[1]=4;intArr[2]=4;intArr[3]=3;intArr[4]=3;

        TriangleStripArray pla =new TriangleStripArray(20, GeometryArray.COLOR_3|GeometryArray.NORMALS|GeometryArray.COORDINATES,intArr);
        pla.setCoordinates(0, plaPts);
        PointAttributes a_point_just_bigger=new PointAttributes();
        a_point_just_bigger.setPointSize(10.0f);//10 pixel-wide point
        a_point_just_bigger.setPointAntialiasingEnable(true);//now points are sphere-like(not a cube)
        app.setPointAttributes(a_point_just_bigger);
        PolygonAttributes la=new PolygonAttributes();
        la.setPolygonMode(PolygonAttributes.POLYGON_FILL);
        la.setCullFace(PolygonAttributes.CULL_NONE);
        app.setPolygonAttributes(la);
        Material matt=new Material();
        matt.setAmbientColor(new Color3f(1,1,1));
        matt.setDiffuseColor(new Color3f(0.5f,0.5f,0.7f));
        matt.setEmissiveColor(new Color3f(0.2f,0.2f,0.3f));
        matt.setShininess(0.5f);
        matt.setSpecularColor(new Color3f(0.4f,0.6f,0.9f));
        matt.setLightingEnable(true);

        app.setMaterial(matt);
        RenderingAttributes ra=new RenderingAttributes();
        ra.setIgnoreVertexColors(true);
        app.setRenderingAttributes(ra);
        Shape3D plShape = new Shape3D(pla, app);

        TransformGroup objRotate = new TransformGroup();

        MouseRotate mr=new MouseRotate();
        mr.setTransformGroup(objRotate);
        mr.setSchedulingBounds(new BoundingSphere());
        lineGroup.addChild(mr);
        MouseZoom mz=new MouseZoom();
        mz.setTransformGroup(objRotate);
        mz.setSchedulingBounds(new BoundingSphere());
        lineGroup.addChild(mz);
        MouseTranslate msl=new MouseTranslate();
        msl.setTransformGroup(objRotate);
        msl.setSchedulingBounds(new BoundingSphere());
        lineGroup.addChild(msl);


        objRotate.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
        objRotate.addChild(plShape);
        AmbientLight al=new AmbientLight();
      //  al.addScope(objRotate);
        al.setBounds(new BoundingSphere());
        al.setEnable(true);
        al.setColor(new Color3f(1,1,1));

        lineGroup.addChild(objRotate);
        lineGroup.addChild(al);
        return lineGroup;
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.add(new JScrollPane(new energon()));
        frame.setSize(300, 300);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}