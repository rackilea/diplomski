public Response getABC(Request request) throws Exception {
    if (request.someProperty != 1) {
        throw new Exception("xxxx");
    }

    Response res = new Response();
    // business logic
    return res;
}