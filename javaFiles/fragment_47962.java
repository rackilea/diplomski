public Response serve(IHTTPSession session) {
    Map<String, String> files = new HashMap<String, String>();
    Method method = session.getMethod();
    if (Method.PUT.equals(method) || Method.POST.equals(method)) {
        try {
            session.parseBody(files);
        } catch (IOException ioe) {
            return new Response(Response.Status.INTERNAL_ERROR, MIME_PLAINTEXT, "SERVER INTERNAL ERROR: IOException: " + ioe.getMessage());
        } catch (ResponseException re) {
            return new Response(re.getStatus(), MIME_PLAINTEXT, re.getMessage());
        }
    }
    // get the POST body
    String postBody = session.getQueryParameterString();
    // or you can access the POST request's parameters
    String postParameter = session.getParms().get("parameter");

    return new Response(postBody); // Or postParameter.
}