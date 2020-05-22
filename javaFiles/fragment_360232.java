// Include any filters in the initial request's `requestOptions`
List<Option> requestOptions = new ArrayList<Option>();
requestOptions.add(new QueryOption("$filter", "startsWith(displayName,'Foo')"));

IGroupCollectionRequest request = graphServiceClient.groups().buildRequest(requestOptions);
IGroupCollectionPage page = request.get();
// Process first page
IGroupCollectionRequestBuilder builder = page.getNextPage();
while (builder != null) {
    request = builder.buildRequest();
    page = request.get();
    // Process each subsequent page
    builder = page.getNextPage();
}