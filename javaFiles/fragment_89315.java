int vertices = 3;

int vertex_size = 3; // X, Y, Z,
int color_size = 3; // R, G, B,

FloatBuffer vertex_data = BufferUtils.createFloatBuffer(vertices * vertex_size);
vertex_data.put(new float[] { -1f, -1f, 0f, });
vertex_data.put(new float[] { 1f, -1f, 0f, });
vertex_data.put(new float[] { 1f, 1f, 0f, });
vertex_data.flip();

FloatBuffer color_data = BufferUtils.createFloatBuffer(vertices * color_size);
color_data.put(new float[] { 1f, 0f, 0f, });
color_data.put(new float[] { 0f, 1f, 0f, });
color_data.put(new float[] { 0f, 0f, 1f, });
color_data.flip();

int vbo_vertex_handle = glGenBuffers();
glBindBuffer(GL_ARRAY_BUFFER, vbo_vertex_handle);
glBufferData(GL_ARRAY_BUFFER, vertex_data, GL_STATIC_DRAW);
glBindBuffer(GL_ARRAY_BUFFER, 0);

int vbo_color_handle = glGenBuffers();
glBindBuffer(GL_ARRAY_BUFFER, vbo_color_handle);
glBufferData(GL_ARRAY_BUFFER, color_data, GL_STATIC_DRAW);
glBindBuffer(GL_ARRAY_BUFFER, 0);