private String getCreatedId(Response response) {
    URI location = response.getLocation();
    if (!response.getStatusInfo().equals(Response.Status.CREATED)) {
        Response.StatusType statusInfo = response.getStatusInfo();
        throw new WebApplicationException("Create method returned status " +
                statusInfo.getReasonPhrase() + " (Code: " + statusInfo.getStatusCode() + "); expected status: Created (201)", response);
    }
    if (location == null) {
        return null;
    }
    String path = location.getPath();
    return path.substring(path.lastIndexOf('/') + 1);
}