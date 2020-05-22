glDeleteVertexArrays(vao_handle); // Deletes the VAO
glDeleteBuffers(vbo_handle); // Deletes the VBO
glDeleteBuffers(ibo_handle); // Deletes the IBO

vao_handle = -1;
vbo_handle = -1;
ibo_handle = -1;