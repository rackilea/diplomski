Future<Response> future = target.request().async().get(new InvocationCallback<Response>(){
    @Override
    public void completed(Response response) {
        System.out.println(response.readEntity(String.class));
        response.close();
        client.close();
    }

    @Override
    public void failed(Throwable throwable) { /** Log exception **/ }
});