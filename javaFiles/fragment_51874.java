class Service {

    Client client;

    public <T> void fix(Function<Client, T> clientCall) {

        T result = clientCall.apply(client);

        // Do something with result

        method();
    }

}