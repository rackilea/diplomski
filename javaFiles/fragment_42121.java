@Path("orders")
public class OrdersResource {
    @GET
    @Produces("text/plain")
    public String get() {}
}

Path anno = OrdersResource.class.getAnnotation(Path.class);
String path = anno.value();
Resource resource = new Resource(path);

Method[] methods = OrdersResource.class.getDeclaredMethods();
for (Method method: methods) {
    Annotation[] methodAnnos = method.getAnnotations();
    if (arrayContains(methodAnnos, (@GET, @POST, @PUT, etc)) {
        String httpMethod = getMethod(methodAnnos);
        ResourceMethod resourceMethod = new ResourceMethod(httpMethod);
        Produces producesAnno = method.getAnnotation(Produces.class);
        if (produces != null) {
            resourceMethod.setProduces(producesAnno.value());
        }
        resource.addResourceMethod(resourceMethod);
    }
}