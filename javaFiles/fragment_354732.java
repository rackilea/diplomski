public class DynamicMessageDeliverer implements MessageDeliverer {

    private final List<ProxyRes>    resources;

    public DynamicMessageDeliverer (List<ProxyRes> resources) {
        this.resources  = resources;
    }

    public void deliverRequest (final Exchange exchange) {
        Request request         = exchange.getRequest ();
        List<String> path       = request.getOptions ().getUriPath ();

        final Resource resource = registerResources (path);     
        if (resource != null) {
            executeResource (exchange, resource);           
        } else {
            exchange.sendResponse (new Response (ResponseCode.NOT_FOUND));
            throw new RuntimeException ("Did not find resource " + path.toString() + " requested by " + request.getSource()+":"+request.getSourcePort());
        }
    }

    private void executeResource (final Exchange exchange, final Resource resource) {
        // Get the executor and let it process the request
        Executor executor = resource.getExecutor ();
        if (executor != null) {
            exchange.setCustomExecutor ();
            executor.execute (new Runnable () {

                public void run () {
                    resource.handleRequest (exchange);
                } 
            });
        } else {
            resource.handleRequest (exchange);
        }
    }

    private Resource registerResources (List<String> list) {
        LinkedList<String> path         = new LinkedList<String> (list);
        String flatRequestedEndpoint    = Arrays.toString (path.toArray ());
        LinkedList<String> wildcards    = new LinkedList <String> ();
        ProxyRes retainedResource       = null;

        for (ProxyRes proxyRes : resources) {
            String[] res = proxyRes.getPath ().replaceFirst ("/", "").split ("/");

            int length = res.length;
            if (length != path.size ()) {
                continue;
            }

            String flatResEndpoint = Arrays.toString (res);
            if (flatResEndpoint.equals (flatRequestedEndpoint)) {
                retainedResource = proxyRes;
                break;
            }

            boolean match = true;

            for (int i = 0; i < length; i ++) {
                String str = res[i];
                if (str.equals ("*")) {
                    wildcards.add (path.get (i));
                    continue;
                }

                if (!str.equals (path.get (i))) {
                    match = false;
                    break;
                }
            }

            if (!match) {
                wildcards.clear ();
                continue;
            }

            retainedResource = proxyRes;
            break;
        }

        if (retainedResource == null) {
            return null;
        }

        ((AbstractResource)retainedResource.getCoapRes ()).setWildcard (wildcards);
        return retainedResource.getCoapRes ();
    }

    public void deliverResponse (Exchange exchange, Response response) {
        if (response == null) throw new NullPointerException();
        if (exchange == null) throw new NullPointerException();
        if (exchange.getRequest() == null) throw new NullPointerException();
        exchange.getRequest().setResponse(response);
        Request request         = exchange.getRequest ();
        List<String> path       = request.getOptions ().getUriPath ();
        System.out.println ("Path retrieved : " + Arrays.toString (path.toArray ()));
    }
}