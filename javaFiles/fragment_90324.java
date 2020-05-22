import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.core.Configuration;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;
import org.glassfish.jersey.process.Inflector;
import org.glassfish.jersey.server.model.ModelProcessor;
import org.glassfish.jersey.server.model.Resource;
import org.glassfish.jersey.server.model.ResourceModel;

@Provider
public class HeadAndOptionsModelProcessor implements ModelProcessor {

    @Override
    public ResourceModel processResourceModel(ResourceModel resourceModel,
            Configuration configuration) {
        ResourceModel.Builder resourceModelBuilder = new ResourceModel.Builder(false);
        for (Resource rootResource: resourceModel.getResources()) {
            final Resource.Builder rootResourceBuilder = Resource.builder(rootResource);
            addOptions(rootResourceBuilder);
            addHead(rootResourceBuilder);

            for (Resource childResource: rootResource.getChildResources()) {
                final Resource.Builder childResourceBuilder = Resource.builder(childResource);
                addOptions(childResourceBuilder);
                addHead(childResourceBuilder);
                rootResourceBuilder.addChildResource(childResourceBuilder.build());
            }
            resourceModelBuilder.addResource(rootResourceBuilder.build());
        }
        return resourceModelBuilder.build();
    }

    @Override
    public ResourceModel processSubResource(ResourceModel subResourceModel,
            Configuration configuration) {
        return subResourceModel;
    }

    private void addOptions(Resource.Builder resourceBuilder) {
        resourceBuilder.addMethod("OPTIONS")
                .handledBy(new Inflector<ContainerRequestContext, Response>() {
                    @Override
                    public Response apply(ContainerRequestContext context) {
                        return getOptionsResponse(context);
                    }
                }).produces(MediaType.TEXT_PLAIN).extended(true);
    }

    private void addHead(Resource.Builder resourceBuilder) {
        resourceBuilder.addMethod("HEAD")
                .handledBy(new Inflector<ContainerRequestContext, Response>() {
                    @Override
                    public Response apply(ContainerRequestContext context) {
                        return getHeadResponse(context);
                    }
                }).produces(MediaType.TEXT_PLAIN).extended(true);
    }

    private static Response getOptionsResponse(ContainerRequestContext context) {
        return Response.status(Response.Status.METHOD_NOT_ALLOWED).entity("No Options").build();
    }

    private static Response getHeadResponse(ContainerRequestContext context) {
        return Response.status(Response.Status.METHOD_NOT_ALLOWED).entity("No Head").build();
    }
}