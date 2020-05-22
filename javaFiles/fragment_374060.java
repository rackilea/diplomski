protected void bindAttributes() {
    int loc = 0;
    super.bindAttribute(GL20.glGetAttribLocation(loc, "position"), "position");
    super.bindAttribute(GL20.glGetAttribLocation(loc, "textureCoords"), "textureCoords");
    super.bindAttribute(GL20.glGetAttribLocation(loc, "normal"), "normal");
}

protected void bindAttribute(int attribute, String variableName){
    GL20.glBindAttribLocation(programID, attribute, variableName);
}