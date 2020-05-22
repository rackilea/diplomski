@Autowired
private PropertyResolver propertyResolver;

private ResourceModel processResourceModel(ResourceModel resourceModel) {
    ResourceModel.Builder newResourceModelBuilder = new ResourceModel.Builder(false);
    for (final Resource resource : resourceModel.getResources()) {
        final Resource.Builder resourceBuilder = Resource.builder(resource);
        String resolvedResourcePath = processPropertyPlaceholder(resource);
        resourceBuilder.path(resolvedResourcePath);

        // handle child resources
        for (Resource childResource : resource.getChildResources()) {
            String resolvedChildPath = processPropertyPlaceholder(childResource);
            final Resource.Builder childResourceBuilder = Resource.builder(childResource);
            childResourceBuilder.path(resolvedChildPath);
                resourceBuilder.addChildResource(childResourceBuilder.build());
        }
        newResourceModelBuilder.addResource(resourceBuilder.build());
    }
    return newResourceModelBuilder.build();
}

private String processPropertyPlaceholder(Resource resource) {
    String ogPath = resource.getPath();
    return propertyResolver.resolvePlaceholders(ogPath);
}