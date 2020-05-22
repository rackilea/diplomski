final HttpClient httpClient = new DefaultHttpClient();

/* initialize httpClient and fetch your login page to get the cookies */

JEditorPane myPane = new JEditorPane() {
    protected InputStream getStream(URL url) throws IOException {

        HttpGet httpget = new HttpGet(url.toExternalForm());

        HttpResponse response = httpClient.execute(httpget);
        HttpEntity entity = response.getEntity();

        // important!  by overriding getStream you're responsible for setting content type!
        setContentType(entity.getContentType().getValue());

        // another thing that you're now responsible for...  this will be used to resolve
        // the images and other relative references.  also beware whether it needs to be a url or string
        getDocument().putProperty(Document.StreamDescriptionProperty, url);

        // using commons-io here to take care of some of the more annoying aspects of InputStream
        InputStream content = entity.getContent();
        try {
            return new ByteArrayInputStream(IOUtils.toByteArray(content));
        }
        catch(RuntimeException e) {
            httpget.abort();  // per example in HttpClient, abort needs to be called on unexpected exceptions
            throw e;
        }
        finally {
            IOUtils.closeQuietly(content);
        }
    }
};

// now you can do this!
myPane.setPage(new URL("http://www.google.com/"));