static void execute(HttpClient client, HttpUriRequest request,
                    Consumer<HttpResponse> handler) {
    client.<Void>execute(request, response -> {
        handler.accept(response);
        return null;
    });
}