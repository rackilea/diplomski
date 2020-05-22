String tenantId = "<the tenantId you copy >";
        String clientId = "<the clientId you copy>";
        String clientSecret= "<the clientSecre you copy>";
        String subscriptionId = "<the subscription id you copy>";
       ApplicationTokenCredentials creds = new 
          ApplicationTokenCredentials(clientId,domain,secret,AzureEnvironment.AZURE);
            RestClient restClient =new RestClient.Builder()
                                   .withBaseUrl(AzureEnvironment.AZURE, AzureEnvironment.Endpoint.RESOURCE_MANAGER)
                                   .withSerializerAdapter(new AzureJacksonAdapter())
                                   .withReadTimeout(150, TimeUnit.SECONDS)
                                   .withLogLevel(LogLevel.BODY)
                                   .withResponseBuilderFactory(new AzureResponseBuilder.Factory())
                                   .withCredentials(creds)
                                   .build();


            ResourceManager resourceClient= ResourceManager.authenticate(restClient).withSubscription(subscriptionId);
            ResourceManagementClientImpl  client=  resourceClient.inner();

            String filter="resourceType eq 'Microsoft.DBforPostgreSQL/servers'"; //The filter to apply on the operation
            String expand=null;//The $expand query parameter. You can expand createdTime and changedTime.For example, to expand both properties, use $expand=changedTime,createdTime
            Integer top =null;// The number of results to return. If null is passed, returns all resource groups.
            PagedList<GenericResourceInner> results= client.resources().list(filter, null,top);
            while (true) {
                for (GenericResourceInner resource : results.currentPage().items()) {

                    System.out.println(resource.id());
                    System.out.println(resource.name());
                    System.out.println(resource.type());
                    System.out.println(resource.location());
                    System.out.println(resource.sku().name());
                    System.out.println("------------------------------");
                }
                if (results.hasNextPage()) {
                    results.loadNextPage();
                } else {
                    break;
                }
            }