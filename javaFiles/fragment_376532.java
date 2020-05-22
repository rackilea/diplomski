CLass Model3D {

    List points = new ArrayList<Point3D>();
    List verts = new ArrayList<Vertex3D>();
}

Model3D m = new Model3D();

ObjectOutputStream oos = new ObjectOutpuStream(new FileOutputStream( new File('./3d-file-otuput') ) );
oos.write(m);