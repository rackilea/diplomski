HttpClient httpClient = HttpClients.custom()
    .setDefaultRequestConfig(RequestConfig.custom()
        .setCookieSpec(CookieSpecs.STANDARD).setRedirectsEnabled(true).build())
    .setRedirectStrategy(new LaxRedirectStrategy() {

        public boolean isRedirected(HttpRequest request, HttpResponse response, HttpContext context)  {
            boolean isRedirect=false;
            try {
                isRedirect = super.isRedirected(request, response, context);
            }
            catch (ProtocolException e) {
                e.printStackTrace();
            }  
            if (!isRedirect) {
               int responseCode = response.getStatusLine().getStatusCode();
                if (responseCode == 301 || responseCode == 302) {
                    return true;
                }
            }
            return isRedirect;
        }
        @Override
        public HttpUriRequest getRedirect(HttpRequest request, HttpResponse response, HttpContext context) throws ProtocolException {
        String cokeis = response.getHeaders("Set-Cookie")[0].getValue();
        HttpRequestBase requestBase = new HttpRequestBase() {
            @Override
            public String getMethod() {
                return "GET";
            }
        };
        requestBase.setURI(getLocationURI(request, response, context));
        requestBase.setHeader("Cookie", cokeis);
        return requestBase;
        }
    })
    .build();

HttpUriRequest request = RequestBuilder.get()
    .setUri("https://example.com/")
    .setHeader("Authorization", "<key>")
    .build();

HttpResponse resp = httpClient.execute(request);
System.out.println(resp.getStatusLine().getStatusCode());