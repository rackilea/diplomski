class EquivalentMesh extends TexturedMesh {

    private MeshHelper mh = null;

    public EquivalentMesh(Parent root) {
        ArrayList<Node> nodes = new ArrayList<>();
        addShapes3D(root, nodes);

        transformAndMerge(nodes);
    }

    // Transform Built-in Shape3Ds to a single TexturedMesh
    private void transformAndMerge(ArrayList<Node> nodes) {

        nodes.stream().forEach(shape -> {
            TriangleMesh tm = null;
            if (shape instanceof Sphere) {
                Sphere sphere = (Sphere)shape;
                SegmentedSphereMesh sm = new SegmentedSphereMesh(sphere.getRadius());
                sm.setCenter(new Point3D((float)sphere.getTranslateX(), (float)sphere.getTranslateY(), (float)sphere.getTranslateZ()));
                tm = (TriangleMesh)sm.getMesh();
            } else if (shape instanceof Cylinder) {
                Cylinder cylinder = (Cylinder)shape;
                FrustumMesh fm = new FrustumMesh(cylinder.getRadius(), cylinder.getRadius(), cylinder.getHeight());
                Affine affine = new Affine();
                cylinder.getTransforms().forEach(affine::append);
                javafx.geometry.Point3D ini = affine.transform(new javafx.geometry.Point3D(0, cylinder.getHeight()/2, 0));
                javafx.geometry.Point3D end = affine.transform(new javafx.geometry.Point3D(0, - cylinder.getHeight()/2, 0));
                fm.setAxisOrigin(new Point3D((float)ini.getX(), (float)ini.getY(), (float)ini.getZ()));
                fm.setAxisEnd(new Point3D((float)end.getX(), (float)end.getY(), (float)end.getZ()));
                fm.setSectionType(TriangleMeshHelper.SectionType.CIRCLE);
                tm = (TriangleMesh)fm.getMesh();
            } else if (shape instanceof Box) {
                Box box = (Box)shape;
                CuboidMesh cm = new CuboidMesh(box.getWidth(), box.getHeight(), box.getDepth());
                cm.setCenter(new Point3D((float)box.getTranslateX(), (float)box.getTranslateY(), (float)box.getTranslateZ()));
                // TODO: apply rotations
                tm = (TriangleMesh)cm.getMesh();
            } else if (shape instanceof MeshView) {
               tm = (TriangleMesh)((MeshView)shape).getMesh();
               // TODO: apply transformations 
            }

            if (mh == null) {
                mh = new MeshHelper(tm);
            } else {
                mh.addMesh(new MeshHelper(tm));
            }
        });

        // create single mesh
        updateMesh(mh);
    }

    private void addShapes3D(Parent parent, ArrayList<Node> nodes) {
        for (Node node : parent.getChildrenUnmodifiable()) {
            if (node instanceof Shape3D) {
                nodes.add(node);
            }
            if (node instanceof Parent) {
                addShapes3D((Parent)node, nodes);
            }
        }
    }

    @Override
    protected void updateMesh() {
        // no-op
    }

    // export to obj and mtl
    public void export(String nameFile) {
        OBJWriter writer=new OBJWriter((TriangleMesh) getMesh(), nameFile);
        writer.setMaterialColor(Color.RED);
        writer.exportMesh();
    }

}