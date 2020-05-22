IGroupCollectionPage page;
IGroupCollectionRequestBuilder builder;

// Build the initial request (including any filters)
List<Option> requestOptions = new ArrayList<Option>();
requestOptions.add(new QueryOption("$filter", "startsWith(displayName,'Foo')"));
IGroupCollectionRequest request = graphServiceClient.groups().buildRequest(requestOptions);

do {
    // Make request
    page = request.get();

    // Process results
    for(Group g: page.getCurrentPage()) {
        System.out.println(g.displayName);
    }

    // Get and build request for next page
    builder = page.getNextPage();
    if (builder == null) {
        request = null;
    } else {
        request = builder.buildRequest();
    }
} while (request != null);