new Material(
    IntAttribute.createCullFace(GL20.GL_FRONT),//For some reason, libgdx ModelBuilder makes boxes with faces wound in reverse, so cull FRONT
    new BlendingAttribute(1f), //opaque since multiplied by vertex color
    new DepthTestAttribute(false), //don't want depth mask or rear cubes might not show through
    ColorAttribute.createDiffuse(Color.WHITE) //white since multiplied by vertex color
    );