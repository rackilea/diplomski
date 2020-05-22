gl.glGenTextures( noOfTextures , textureNames);

for (int i=0; i<noOfTextures; i++) {

    TextureData textureData = TextureIO.newTextureData(glProfile,
        new File( textureFilename[i] ), false, TextureIO.JPG);

    gl.glBindTexture(gl.GL_TEXTURE_2D, textureNames.get(i));

    gl.glTexImage2D( ..... );    

    .....
}