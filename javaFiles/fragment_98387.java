public class Mesh2CSG {
    /**
     * Loads a CSG from TriangleMesh.
     * @param mesh
     * @return CSG
     * @throws IOException if loading failed
     */
    public static CSG mesh2CSG(MeshView mesh) throws IOException {
        return mesh2CSG(mesh.getMesh());
    }
    public static CSG mesh2CSG(Mesh mesh) throws IOException {

        List<Polygon> polygons = new ArrayList<>();
        List<Vector3d> vertices = new ArrayList<>();
        if(mesh instanceof TriangleMesh){
            // Get faces
            ObservableFaceArray faces = ((TriangleMesh)mesh).getFaces();
            int[] f=new int[faces.size()];
            faces.toArray(f);

            // Get vertices
            ObservableFloatArray points = ((TriangleMesh)mesh).getPoints();
            float[] p = new float[points.size()];
            points.toArray(p);

            // convert faces to polygons
            for(int i=0; i<faces.size()/6; i++){
                int i0=f[6*i], i1=f[6*i+2], i2=f[6*i+4];
                vertices.add(new Vector3d(p[3*i0], p[3*i0+1], p[3*i0+2]));
                vertices.add(new Vector3d(p[3*i1], p[3*i1+1], p[3*i1+2]));
                vertices.add(new Vector3d(p[3*i2], p[3*i2+1], p[3*i2+2]));
                polygons.add(Polygon.fromPoints(vertices));
                vertices = new ArrayList<>();
            }
        }

        return CSG.fromPolygons(new PropertyStorage(),polygons);
    }
}