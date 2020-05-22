vbo.bind(GL_ARRAY_BUFFER);
vbo.uploadSubData(GL_ARRAY_BUFFER, 0, vertices);
ibo.bind(GL_ELEMENT_ARRAY_BUFFER);
ibo.uploadSubData(GL_ELEMENT_ARRAY_BUFFER, 0, indices);

glDrawElements(GL_TRIANGLES, GL_SHORT, numIndices, null);