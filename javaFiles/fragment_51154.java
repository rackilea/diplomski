private class ignoreXHeaderWebClient extends WebViewClient{  
   private static final String URL_MASK       =  "http";


    //api < 21
    @Override
    public WebResourceResponse shouldInterceptRequest (final WebView view, String url) {
        WebResourceResponse content = getsPageContent(url);
        if (content != null) {
            return content;
        } else {
            return super.shouldInterceptRequest(view, url);
        }
    }

   // api >= 21
    @Override  
    public WebResourceResponse shouldInterceptRequest(WebView view, WebResourceRequest request) {
        WebResourceResponse content = getsPageContent(request.getUrl().toString());
        if (content != null) {
            return content;
        } else {
            return super.shouldInterceptRequest(view, request);  
        }
    }   

    private WebResourceResponse getsPageContent(String url){
        if (( url.contains(URL_MASK)) // guess is better to create for ex map to check all extensions
                && !(( url.contains(".js")) 
                      ||( url.contains(".css"))
                      ||( url.contains(".tiff"))
                      ||( url.contains(".jpg"))
                      ||( url.contains(".png"))
                      ||( url.contains(".gif")))){    
            try {  
                return new WebResourceResponse(
                              "text/html",    
                              "UTF-8",   
                              new ByteArrayInputStream( 
                                   Jsoup.connect(url)
                                           .get()  
                                           .toString()
                                           .getBytes()));  
            } catch (IOException e) {
                e.printStackTrace();    
            }   
        }
        return null;
    } 
}