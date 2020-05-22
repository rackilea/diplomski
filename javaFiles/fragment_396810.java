public static class CustomBadRequestType implements Response.StatusType {

    @Override
    public int getStatusCode() {
        return 400;
    }

    @Override
    public String getReasonPhrase() {
        return "My Reason";
    }

    @Override
    public Response.Status.Family getFamily() {
        return Response.Status.Family.CLIENT_ERROR;
    }
}