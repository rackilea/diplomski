@Bean
public ResourceProcessor<ResourceSupport> organisationProcessor() {
    return resource -> {
        resource.removeLinks();
        return resource;
    };
}