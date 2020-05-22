public Model resolveEffectiveModel(File pomfile) {
    try {
        return modelBuilder.build(makeModelBuildRequest(pomfile)).getEffectiveModel();
    } catch (Exception e) {
        throw new RuntimeException(e);
    }   
}

private ModelBuildingRequest makeModelBuildRequest(File artifactFile) {
    DefaultModelBuildingRequest mbr = new DefaultModelBuildingRequest();
    mbr.setPomFile(artifactFile);
    mbr.setModelResolver(modelResolver); // <-- the hard-to-get modelResolver
    return mbr;
}