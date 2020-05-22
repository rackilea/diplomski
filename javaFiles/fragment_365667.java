public class ForbiddenExceptionClientFilter extends ClientFilter {

    @Override
    public ClientResponse handle(ClientRequest cr) throws ClientHandlerException {
        ClientResponse response = getNext().handle(cr);

        if (response.getStatus() == Status.FORBIDDEN.getStatusCode()) {
            ForbiddenEntity reason = response.getEntity(ForbiddenEntity.class);
            throw new RemoteResourceForbiddenException(reason.getCode(), reason.getReadableMessage());
        }

        return response;
    }

}