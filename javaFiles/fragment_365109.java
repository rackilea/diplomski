//this is how to get the properly sized mesh:
float[] vertices = new float[mesh.getNumVertices() * mesh.getVertexSize() / 4];
mesh.getVertices(vertices);

for (int i = yOffset; i < vertices.length; i += vertexSize){
    vertices[i] += someValue;
}
mesh.setVertices(vertices);