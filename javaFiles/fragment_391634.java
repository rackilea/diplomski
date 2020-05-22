class ResposeKeepAliveHeaderMod implements HttpResponseInterceptor {

    @Override
    public void process(HttpResponse response, HttpContext context)
            throws HttpException, IOException {
        final Header explicit = response.getFirstHeader(HTTP.CONN_DIRECTIVE);
        if (explicit != null && HTTP.CONN_CLOSE.equalsIgnoreCase(explicit.getValue())) {
            // Connection persistence explicitly disabled
            return;
        }else{
            // "Connection: Keep-Alive" and "Keep-Alive: timeout=x, max=y" 
            response.setHeader(HTTP.CONN_DIRECTIVE, HTTP.CONN_KEEP_ALIVE);
            response.setHeader(HTTP.CONN_KEEP_ALIVE, "timeout=30, max=100");
        }

    }      
   }