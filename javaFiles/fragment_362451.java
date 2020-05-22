Client client = Client.create();
client.addFilter( new HTTPBasicAuthFilter( userId, password ) );
client.addFilter( new ClientFilter() {

    @Override
    public ClientResponse handle( ClientRequest cr )
       throws ClientHandlerException {
           List<Object> cacheControlRequestValues = new ArrayList<Object>();
           cacheControlRequestValues.add( "no-cache" );
           cacheControlRequestValues.add( "no-store" );
           cr.getHeaders().put( HttpHeaders.CACHE_CONTROL, cacheControlRequestValues );
           return getNext().handle( cr );
    }
}