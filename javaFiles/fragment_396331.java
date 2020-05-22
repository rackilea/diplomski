public class DirectoryResolverResource implements IResource {
    private static final long serialVersionUID = 1L;

    private File servedDirectory;
    private String urlPrefix;

    //served directory is the directory you want to mount as a static sub-site
    //urlPrefix is the mountpoint where you're going to mount this resource, without the leading "/". E.g.: if you mount your directory in "/help" so that the sub-site URL is www.yoursite.com/pages/help the urlPrefix value must be "help"
    public DirectoryResolverResource(File servedDirectory, String urlPrefix) {
        super();
        if (servedDirectory == null || !servedDirectory.isDirectory()) {
            throw new IllegalArgumentException("Directory is null or doesn't exist");
        }
        this.servedDirectory = servedDirectory;
        this.urlPrefix = urlPrefix;
    }

    @Override
    public void respond(Attributes attributes) {
        Url url = attributes.getRequest().getUrl();
        String subPath = "";
        try {
            //we decode the URL by reversing the percent-encoding, so that filenames are properly resolved
            subPath = URLDecoder.decode(url.toString(), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new AbortWithHttpErrorCodeException(HttpServletResponse.SC_BAD_REQUEST, "Encoding is invalid");
        }

        if (subPath.startsWith(urlPrefix)) {
            subPath = subPath.substring(urlPrefix.length());
        } else {
            throw new AbortWithHttpErrorCodeException(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Url is invalid");
        }

        File file = new File(servedDirectory.getAbsolutePath() + (subPath.startsWith("/") ? "" : "/") + subPath);
        if (file.isDirectory()) {
            // In case of a directory, redirect to the path ending in "/", otherwise browsers will fail to resolve relative paths in the page
            if (!subPath.endsWith("/")) {
                throw new RedirectToUrlException("." + (subPath.isEmpty() ? "/" + urlPrefix : subPath) + "/", HttpServletResponse.SC_MOVED_PERMANENTLY);
            }
            // no specific file specified, try to return index.html
            file = new File(file.getAbsolutePath(), "index.html");
        }
        if (!file.exists() || file.isDirectory()) {
            // file not found
            throw new AbortWithHttpErrorCodeException(HttpServletResponse.SC_NOT_FOUND, "Resource not found");
        }

        if (!FSManager.isInSubDirectory(servedDirectory, file)) {
            // Security check: user is trying to escape the served directory via a non-canonical path
            throw new AbortWithHttpErrorCodeException(HttpServletResponse.SC_FORBIDDEN, "Access to this resource is forbidden");
        }

        // Serve the file
        FileResourceStream fileResourceStream = new FileResourceStream(file);
        ResourceStreamResource resource = new ResourceStreamResource(fileResourceStream);
        resource.respond(attributes);
    }

}