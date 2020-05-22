public class MyWebResource extends WebResource {
    final ValueMap map = new ValueMap();

    @Override
    public IResourceStream getResourceStream() {        
        String fileName = getFileName();
        File file = new File(basePath, fileName);

        if (!file.exists()) {
            LOG.error("File does not exist: " + file);
            throw new IllegalStateException("File does not exist: " + file);
        }       
        return new FileResourceStream(file);
    }           

    public final void addResource() {
        Application.get().getSharedResources().add(getClass().getName(), this);
    }

    protected String getFileName() {
        return getParameters().getString("id");
    }   

    public final String urlFor(final String fileName) {         
        final ResourceReference resourceReference = new ResourceReference(getClass().getName());        
        final String encodedValue = WicketURLEncoder.QUERY_INSTANCE.encode(fileName);
        map.add("id", encodedValue);
        final CharSequence result = RequestCycle.get().urlFor(resourceReference, map);       
        if (result == null) {
            throw new IllegalStateException("The resource was not added! "
                + "In your Application class add the following line:"
                + "MyConcreteResource.INSTANCE.addResource()");
        }   

        String absoluteUrl = RequestUtils.toAbsolutePath(result.toString());        
        return absoluteUrl;     
    } 
}