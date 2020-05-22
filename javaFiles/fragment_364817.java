public class GroupOBJWriter {

    private final String newline = System.getProperty("line.separator");
    private float[] points0, texCoord0;
    private int[] faces0, sm0;
    private BufferedWriter writer = null;
    private final String fileName;
    private String diffuseMap;
    private String diffuseColor = "0.0 0.0 0.0"; // black
    private final Group group;

    public GroupOBJWriter(Group group, String fileName){
        this.group = group;
        this.fileName = fileName;
    }

    public void exportMesh(){
        File objFile = new File(fileName + ".obj");
        try{
            writer = new BufferedWriter(new FileWriter(objFile));
            writer.write("mtllib " + fileName + ".mtl" + newline);

            AtomicInteger counter = new AtomicInteger();
            AtomicInteger vCounter = new AtomicInteger();

            group.getChildren().stream()
                .filter(MeshView.class::isInstance)
                .map(s -> (TriangleMesh) ((MeshView) s).getMesh())
                .forEach(mesh -> {
                    try{
                        writer.write("# Material" + newline);
                        int count = counter.getAndIncrement();
                        writer.write("usemtl " + fileName + "-" + count + ""+newline);

                        points0 = new float[mesh.getPoints().size()];
                        mesh.getPoints().toArray(points0);
                        List<Point3D> points1 = IntStream.range(0, points0.length/3)
                            .mapToObj(i -> new Point3D(points0[3*i], points0[3*i+1], points0[3*i+2]))
                            .collect(Collectors.toList());

                        writer.write("# Vertices (" + points1.size() + ") for shape " + count + "" + newline);
                        points1.forEach(p -> {
                            try {
                                writer.write("v " + p.x + " " + p.y + " " + p.z + "" + newline);
                            } catch (IOException ex) {
                                System.out.println("Error writting vertex "+ex);
                            }
                        });
                        writer.write(newline);

                        texCoord0 = new float[mesh.getTexCoords().size()];
                        mesh.getTexCoords().toArray(texCoord0);

                        List<Point2D> texCoord1 = IntStream.range(0, texCoord0.length/2)
                                .mapToObj(i -> new Point2D(texCoord0[2*i], texCoord0[2*i+1]))
                                .collect(Collectors.toList());

                        writer.write("# Textures Coordinates (" + texCoord1.size() + ") for shape " + count + "" + newline);
                        texCoord1.forEach(t->{
                            try {
                                // objimporter u->u, v->(1-v)
                                writer.write("vt " + ((float) t.getX()) + " " + ((float) (1d - t.getY())) + "" +newline);
                            } catch (IOException ex) {
                                System.out.println("Error writting texture coordinate " + ex);
                            }
                        });
                        writer.write(newline);

                        faces0 = new int[mesh.getFaces().size()];
                        mesh.getFaces().toArray(faces0);
                        List<Integer[]> faces1 = IntStream.range(0, faces0.length/6)
                                .mapToObj(i -> new Integer[]{faces0[6*i], faces0[6*i+1], 
                                    faces0[6*i+2], faces0[6*i+3], 
                                    faces0[6*i+4], faces0[6*i+5]})
                                .collect(Collectors.toList());

                        writer.write("# Faces (" + faces1.size() + ") for shape " + count + "" + newline);
                        writer.write("# Material for shape " + count + "" + newline);
                        writer.write("usemtl " + fileName + "-" + count + "" + newline);
                        sm0 = new int[mesh.getFaces().size()];
                        mesh.getFaceSmoothingGroups().toArray(sm0);
                        if (sm0[0] > 0) {
                            writer.write("s " + sm0[0] + "" + newline);
                        }

                        AtomicInteger c = new AtomicInteger();
                        final int inc = vCounter.get() + 1;
                        faces1.forEach(f->{
                            try {
                                writer.write("f " + (f[0] + inc) + "/" + (f[1] + inc) +
                                              " " + (f[2] + inc) + "/" + (f[3] + inc) +
                                              " " + (f[4] + inc) + "/" + (f[5] + inc) + "" + newline);
                                if (sm0[c.getAndIncrement()] != sm0[c.get()]) {
                                    writer.write("s " + (sm0[c.get()] > 0 ? sm0[c.get()] : "off" ) + "" + newline);
                                }
                            } catch (IOException ex) {
                                System.out.println("Error writting face "+ex);
                            }
                        });
                        vCounter.addAndGet(points1.size());
                        writer.write(newline);
                    } catch(IOException io){
                        System.out.println("Error creating writer obj " + io);
                    }
                });
        } catch(IOException io){
             System.out.println("Error creating writer obj "+io);
        } finally {
            try {
                if(writer!=null){
                    writer.close();
                }
            } catch (Exception e) {}
        }

        File mtlFile = new File(fileName+".mtl");

        try{
            writer = new BufferedWriter(new FileWriter(mtlFile));

            AtomicInteger counter = new AtomicInteger();
            group.getChildren().stream()
                .filter(MeshView.class::isInstance)
                .map(s -> ((PhongMaterial) ((MeshView) s).getMaterial()).getDiffuseColor())
                .forEach(color -> {
                    try{
                        diffuseColor=""+((float)(color.getRed()))+" "+((float)(color.getGreen()))+" "+((float)(color.getBlue()));

                        int count = counter.getAndIncrement();
                        writer.write("# Material " + fileName + "-" + count + "" + newline);
                        writer.write("newmtl " + fileName + "-" + count + "" + newline);
                        writer.write("illum 4" + newline); // Illumination [0-10]
                        writer.write("Kd " + diffuseColor + "" + newline); // diffuse color black
                        writer.write("Ka 0.10 0.10 0.10" + newline); // ambient color
                        writer.write("Tf 1.00 1.00 1.00" + newline); // Transmission filter
                        if (diffuseMap != null) {
                            writer.write("map_Kd " + diffuseMap + "" + newline);
                        }
                        writer.write("Ni 1.00" + newline); // optical density
                        writer.write("Ks 1.00 1.00 1.00" + newline); // specular reflectivity
                        writer.write("Ns 32.00" + newline); // specular exponent
                        writer.write(newline);
                    } catch(IOException io){
                        System.out.println("Error creating writer obj " + io);
                    }
                });
        } catch(IOException io){
             System.out.println("Error creating writer mtl "+io);
        } finally {
            try {
                if(writer!=null){
                    writer.close();
                }
            } catch (Exception e) {}
        }
    }
}