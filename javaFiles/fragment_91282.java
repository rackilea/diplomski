MeshBuilder meb = new MeshBuilder();
    final long atr = Usage.Position | Usage.Color; //Add  Usage.TextureCoordinates or similar here if you need it

    //Create mesh #1
    meb.begin(atr);
    meb.cylinder(4f, 6f, 4f, 16);
    Mesh cyl1 = meb.end();

    //Create mesh #2
    meb.begin(atr);
    meb.cylinder(4f, 6f, 4f, 16);
    Mesh cyl2 = meb.end();

    //Combine the two meshes into one model using ModelBuilder
    ModelBuilder mob = new ModelBuilder();
    mob.begin();
    mob.part("cylinder1", cyl1, Usage.Position | Usage.Normal | Usage.TextureCoordinates, new Material(ColorAttribute.createDiffuse(Color.RED), ColorAttribute.createSpecular(1, 1, 1, 1), FloatAttribute.createShininess(8f)));
    mob.part("cylinder2", cyl2, Usage.Position | Usage.Normal | Usage.TextureCoordinates, new Material(ColorAttribute.createDiffuse(Color.GREEN), ColorAttribute.createSpecular(1, 1, 1, 1), FloatAttribute.createShininess(8f))).mesh.transform(new Matrix4().translate(0, 0, -2f));
    Model cyl = mob.end();