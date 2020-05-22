@Autowired
ResourceHttpRequestHandler resourceHandler;

String uri = "/css/mycss.css";
Resource resource;
for (ResourceResolver resourceResolver : resourceHandler.getResourceResolvers())
{
    resource = resourceResolver.resolveResource(null, uri, resourceHandler.getLocations(), null);
    if (resource != null)
        break;
}