public class OrganizationResourceProcessor implements ResourceProcessor<Resource<OrganisationSelectProjection>> {
    @Override
    public Resource<OrganisationSelectProjection> process(Resource<OrganisationSelectProjection> resource) {
        resource.removeLinks();
        return resource;
    }
}

@Bean
public OrganizationResourceProcessor  organisationProcessor() {
    return new OrganizationResourceProcessor();
}