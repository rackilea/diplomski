glBindBuffer(GL_ARRAY_BUFFER, vbo_vertex_handle);
glVertexPointer(vertex_size, GL_FLOAT, 0, 0l);

glBindBuffer(GL_ARRAY_BUFFER, vbo_color_handle);
glColorPointer(color_size, GL_FLOAT, 0, 0l);

glEnableClientState(GL_VERTEX_ARRAY);
glEnableClientState(GL_COLOR_ARRAY);

glDrawArrays(GL_TRIANGLES, 0, vertices);

glDisableClientState(GL_COLOR_ARRAY);
glDisableClientState(GL_VERTEX_ARRAY);