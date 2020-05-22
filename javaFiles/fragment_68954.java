private TexCoordGeneration generateTexCoord(Shape3D shape) {
    BoundingBox bb = new BoundingBox(shape.getBounds());
    Point3d lower = new Point3d();
    Point3d upper = new Point3d();
    bb.getLower(lower);
    bb.getUpper(upper);

    double width = upper.x - lower.x;
    double height = upper.y - lower.y;
    double deep = upper.z - lower.z;
    Vector4f planeX = new Vector4f((float)(1.0/width), 0.0f, 0.0f, (float)(-lower.x/width));
    Vector4f planeY = new Vector4f(0.0f, (float)(1.0/height), 0.0f, (float)(-lower.y/height));
    Vector4f planeZ = new Vector4f(0.0f, 0.0f, (float)(1.0/deep), (float)(-lower.z/deep));

    TexCoordGeneration tcg = new TexCoordGeneration(TexCoordGeneration.OBJECT_LINEAR, TexCoordGeneration.TEXTURE_COORDINATE_2);
    if(width == 0) { // RIGHT, LEFT: YZ
        tcg.setPlaneS(planeZ);
        tcg.setPlaneT(planeY);
    } else if(height == 0) { // TOP, BOTTOM: XZ
        tcg.setPlaneS(planeX);
        tcg.setPlaneT(planeZ);
    } else { // FRONT, BACK: XY
        tcg.setPlaneS(planeX);
        tcg.setPlaneT(planeY);
    }
    return tcg;
}