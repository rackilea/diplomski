ModelBuilder modelBuilder = new ModelBuilder();
modelBuilder.begin();
modelBuilder.part("cone", GL20.GL_TRIANGLES, Usage.Position | Usage.Normal | Usage.TextureCoordinates, cMaterial)
.cone(40f,250f,40f,8);
modelBuilder.part("cylinder", GL20.GL_TRIANGLES, Usage.Position | Usage.Normal | Usage.TextureCoordinates, boxMaterial)
.cylinder(20, 320, 20, 12);
Model model = modelBuilder.end();