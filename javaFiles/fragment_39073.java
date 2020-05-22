Group lineGroup = new Group();

    Appearance app = new Appearance();
    ColoringAttributes ca = new ColoringAttributes(black, ColoringAttributes.SHADE_FLAT);
    app.setColoringAttributes(ca);

    Computing comp = new Computing();
    comp.do_the_job();

    Point3f[] plaPts = new Point3f[Computing.computed_values.size()];
    for(int i = 0; i < Computing.computed_values.size(); i++)
    {           
        plaPts[i] = new Point3f((float)Computing.computed_values.get(i).getX(), (float)Computing.computed_values.get(i).getY(), (float)Computing.computed_values.get(i).getZ());            
    }

    PointArray pla = new PointArray(Computing.computed_values.size(), GeometryArray.COORDINATES);
    pla.setCoordinates(0, plaPts);
    Shape3D plShape = new Shape3D(pla, app);
    lineGroup.addChild(plShape);

    return lineGroup;