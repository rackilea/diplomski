public final class SerializingExceptionMapper implements ExceptionMapper<Exception> {
    @Override
    public Response toResponse(Exception exception) {
        try {
            final byte[] serializedException = serializeException(exception);
            final String base64EncodedException = Base64.getEncoder().encodeToString(serializedException);

            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(new Message(base64EncodedException))
                    .build();
        } catch (Exception ex) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    private byte[] serializeException(Exception ex) throws IOException {
        final ByteArrayOutputStream bos = new ByteArrayOutputStream();
        final ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(ex);
        oos.close();
        return bos.toByteArray();
    }
}

final class Message {
    public Message(String exception) {
        this.exception = exception;
    }

    public String exception;
}