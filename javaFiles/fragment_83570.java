Filter preferencesFilter = new Filter(getContext()) {
    protected int beforeHandle(Request request, Response response) {
        if (request.getClientInfo().getAcceptedMediaTypes().isEmpty()) {
            request.getClientInfo().accept(MediaType.APPLICATION_JSON);
        } else if ((request.getClientInfo().getAcceptedMediaTypes().size() == 1)
            && (request.getClientInfo().getAcceptedMediaTypes().get(0).getMetadata().equals(MediaType.ALL))) {
            request.getClientInfo().accept(MediaType.APPLICATION_JSON);
        }
        return super.beforeHandle(request, response);
    }            
}