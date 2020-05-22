public class CachedWebAssetsDirectory extends Directory {
    public CachedWebAssetsDirectory(Context context, Reference rootLocalReference) {
        super(context, rootLocalReference);
        setTargetClass(WebAssetsResource.class); // Needed so that Restlet will use our implementation of a ServerResource to serve static files
    }
}