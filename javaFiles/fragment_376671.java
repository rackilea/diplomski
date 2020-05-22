MultiThreadedHttpConnectionManager connectionManager = new MultiThreadedHttpConnectionManager();
HttpClient httpClient = new HttpClient(connectionManager);

// Only needed if you have a authentication
Credentials credentials = new UsernamePasswordCredentials(username, password);
httpClient.getState().setCredentials(AuthScope.ANY, credentials);
httpClient.getParams().setAuthenticationPreemptive(true);

clientExecutor = new ApacheHttpClientExecutor(httpClient);

MyClass client = ProxyFactory.create(MyClass.class, "http://localhost:8080", clientExecutor);