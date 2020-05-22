setupShaders(legacyGL);
bindImage();
GL30.glBindVertexArray(vao);
setVertexAttribs();
GL20.glUseProgram(shaderProgram);
setUniformVars();