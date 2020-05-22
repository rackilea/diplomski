public MeshView createCuboid(float w, float h, float d) {
    float hw = w / 2f;
    float hh = h / 2f;
    float hd = d / 2f;

    float points[] = {
            hw,  hh,  hd,
            hw,  hh, -hd,
            hw, -hh,  hd,
            hw, -hh, -hd,
            -hw,  hh,  hd,
            -hw,  hh, -hd,
            -hw, -hh,  hd,
            -hw, -hh, -hd};

    float tex[] = {
            0.01f, 0.01f,
            0.01f, 0.99f};

    float normals[] = {
            1f,  0f,  0f,
            -1f,  0f,  0f,
            0f,  1f,  0f,
            0f, -1f,  0f,
            0f,  0f,  1f,
            0f,  0f, -1f,
    };

    int faces[] = {
            0, 0, 0, 2, 0, 1, 1, 0, 0,
            2, 0, 1, 3, 0, 1, 1, 0, 0,
            4, 1, 0, 5, 1, 0, 6, 1, 1,
            6, 1, 1, 5, 1, 0, 7, 1, 1,
            0, 2, 0, 1, 2, 0, 4, 2, 0,
            4, 2, 0, 1, 2, 0, 5, 2, 0,
            2, 3, 1, 6, 3, 1, 3, 3, 1,
            3, 3, 1, 6, 3, 1, 7, 3, 1,
            0, 4, 0, 4, 4, 0, 2, 4, 1,
            2, 4, 1, 4, 4, 0, 6, 4, 1,
            1, 5, 0, 3, 5, 1, 5, 5, 0,
            5, 5, 0, 3, 5, 1, 7, 5, 1};

    TriangleMesh mesh = new TriangleMesh();
    mesh.setVertexFormat(VertexFormat.POINT_NORMAL_TEXCOORD);
    mesh.getPoints().addAll(points);
    mesh.getTexCoords().addAll(tex);
    mesh.getNormals().addAll(normals);
    mesh.getFaces().addAll(faces);

    return new MeshView(mesh);
}