ModelBuilder modelBuilder = new ModelBuilder();
modelBuilder.begin();
MeshPartBuilder builder = modelBuilder.part("line", 1, 3, new Material());
builder.setColor(Color.RED);
builder.line(0.0f, 0.0f, -5.0f, 0.0f, 0.0f, 5.0f);
lineModel = modelBuilder.end();
lineInstance = new ModelInstance(lineModel);