// Creating the VBO
vbo_handle = glGenBuffers();

glBindBuffer(GL_ARRAY_BUFFER, vbo_handle);
glBufferData(GL_ARRAY_BUFFER, vbo_data, GL_DYNAMIC_DRAW);
glBindBuffer(GL_ARRAY_BUFFER, 0);

// Creating the IBO
ibo_handle = glGenBuffers();

glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, ibo_handle );
glBufferData(GL_ELEMENT_ARRAY_BUFFER, ibo_data, GL_DYNAMIC_DRAW);
glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, 0);

// Creating the VAO
vao_handle = glGenVertexArrays();

glBindVertexArray(vao_handle);

glBindBuffer(GL_ARRAY_BUFFER, vbo_handle);

glEnableVertexAttribArray(INDEX); // Place your own INDEX value in the parenthesis
glVertexAttribPointer(INDEX, SIZE, TYPE, NORMALIZED, STRIDE, OFFSET); // Replace all the VARIABLES with the values which fit to your VAO, VBO and IBO

glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, ibo_handle);

glBindVertexArray(0);

/*
 * Remember that the INDEX given in the
 * glEnableVertexAttribArray() and in
 * glVertexAttribPointer() is the same
 * INDEX used in Shaders (GLSL)
 *
 * If the INDEX is 0 then in GLSL it
 * should look like this
 * GLSL: layout(location = 0) in vec3 position;
 *
 * ^ we can ignore this if you aren't
 * using Shaders, though keep it in mind
 * since we might need it in the future
 */