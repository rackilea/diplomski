public class ETagFilter extends Filter {

    @Override
    protected int beforeHandle(Request request, Response response) {
        addEtag(request);
        return super.beforeHandle(request, response);
    }

    @Override
    protected void afterHandle(Request request, Response response) {
        saveEtag(request, reponse);
        super.afterHandle(request, response);
    }
}

public class RestLetClient extends Application {

    public Representation get(final String uri) throws Exception {

        Client client = new Client(Protocol.HTTP);
        ETagFilter eTagFilter = new ETagFilter();
        clientResource = new ClientResource(uri);

        clientResource.setNext(eTagFilter);
        eTagFilter.setNext(client);

        return clientResource.get(halMediaType);
    }
}