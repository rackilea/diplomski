PlatformGeometry pg = new PlatformGeometry();

    TransformGroup objScale = new TransformGroup();
    Transform3D t3d = new Transform3D();
    t3d.setTranslation(new Vector3f(0f, 0f, -1f));
    objScale.setTransform(t3d);

    Text2D text = new Text2D("Text to display", Cell.BLACK, "Verdana", 18, 1);

    objScale.addChild(text);
    pg.addChild(objScale);

    simpleUniverse.getViewingPlatform().setPlatformGeometry(pg);