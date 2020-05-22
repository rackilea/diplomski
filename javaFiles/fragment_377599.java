public class TransformingResource extends Resource {
    private Resource resource;

    protected TransformingResource(Resource resource) {
        this.resource = resource;   
    }

    @Override
    public boolean isContainedIn(Resource r) throws MalformedURLException {
        return resource.isContainedIn(r);
    }

    @Override
    public void close() {
        resource.close();
    }

    @Override
    public boolean exists() {
        return resource.exists();
    }

    @Override
    public boolean isDirectory() {
        return resource.isDirectory();
    }

    @Override
    public long lastModified() {
        return resource.lastModified();
    }

    @Override
    public long length() {
        transform();

        return transformed.length();
    }

    @Override
    public URL getURL() {
        return resource.getURL();
    }

    @Override
    public File getFile() throws IOException {
        return resource.getFile();
    }

    @Override
    public String getName() {
        return resource.getName();
    }

    private String transformed;

    private void transform() {
        if(transformed != null) {
            return;
        }

        transformed = transformInputStream(resource.getInputStream());
    }

    @Override
    public InputStream getInputStream() throws IOException {
        transform();

        return new ByteArrayInputStream(transformed.getBytes(Charset.forName("UTF-8")));
    }

    @Override
    public ReadableByteChannel getReadableByteChannel() throws IOException {
        return null;
    }

    @Override
    public boolean delete() throws SecurityException {
        return resource.delete();
    }

    @Override
    public boolean renameTo(Resource dest) throws SecurityException {
        return resource.renameTo(dest);
    }

    @Override
    public String[] list() {
        return resource.list();
    }

    @Override
    public Resource addPath(String path) throws IOException,
            MalformedURLException {
        Resource toReturn = resource.addPath(path);
        if(toReturn == null) {
            return null;
        }

        return new TransformingResource(toReturn);
    }
}