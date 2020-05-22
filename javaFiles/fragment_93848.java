public CubeCollider setCube(float x, float y, float z, float m, float n, float o){
    a = new Point3D(x,y,z);
    b = new Point3D(x,n,z);
    c = new Point3D(x,y,o);
    ...
    return this;
}