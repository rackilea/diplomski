Credentials credentials = new UsernamePasswordCredentials(userId, password);
   HttpClient httpClient = new HttpClient();
   httpClient.getState().setCredentials(AuthScope.ANY, credentials);
   httpClient.getParams().setAuthenticationPreemptive(true);

   ClientExecutor clientExecutor = new ApacheHttpClientExecutor(httpClient);

   ServiceApi client = ProxyFactory.create(ServiceApi.class, baseUri, clientExecutor);