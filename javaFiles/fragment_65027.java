FloatBuffer verticesNormals;
// ... code to initialize verticesNormals ...
// verticesNormals contains 6 floats for each vertex. The first three
// define the position and the next three define the normal.

gl.glVertexPointer(3, gl.GL_FLOAT, 24, verticesNormals);

// Create a buffer that points 3 floats past the beginning.
FloatBuffer normalData = mVerticesNormals.duplicate();
normalData.position(3);

gl.glNormalPointer(gl.GL_FLOAT, 24, normalData);