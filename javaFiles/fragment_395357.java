import org.jboss.resteasy.annotations.providers.jaxb.Wrapped;

@GET
@Produces(MediaType.APPLICATION_XML)
@Wrapped(element = "foobars")
public Object getFoobars() {
    return new GenericEntity<List<FooBar>>(service.getFooBars());
}