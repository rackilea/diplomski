private static Response respond(Responder responder) {
    try {
        return responder.handleRequest();
    } catch (MyCustomException e1) {
        return Response.status(409).build();
    } catch (UnauthorizedException e2) {
        return Response.status(401).build();
    } catch (Exception e3) {
        return Response.status(500).build();
    }
}