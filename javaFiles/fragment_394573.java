DefaultModelBuilderFactory factory = new DefaultModelBuilderFactory();
DefaultModelBuilder builder = factory.newInstance();
ModelBuildingRequest req = new DefaultModelBuildingRequest();
req.setProcessPlugins(false);
req.setModelResolver(createModelResolver());
req.setValidationLevel(ModelBuildingRequest.VALIDATION_LEVEL_MINIMAL);
for (File pomFile : pomFiles) {
   req.setPomFile(pomFile);
   Model effectivePom = builder.build(req).getEffectiveModel();
   ...
}