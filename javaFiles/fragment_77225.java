public Response getABC(Request request) {
    Response res = new Response();
    if (request.someProperty == 1) {
        // business logic
    } else {
        res.setMessage("xxxx");
    }
    return res;
}