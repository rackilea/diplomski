public static class CustomModel {

    @Context
    public SecurityContext securityContext;
    public RequestBody body;
}

public static class RequestBody {

    public String message;
}