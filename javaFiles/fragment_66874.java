@Path("{name}")
public Object getNamedResource(@Context UriInfo uriInfo) {
    boolean lastElement = uriInfo.getMatchedURIs()
                           .iterator().next().equals(uriInfo.getPath());
    if (lastElement && "data".equals(name)) {
        return getDataResource(uriInfo);
    }
    ...
}