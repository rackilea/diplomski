GetMethod get = new GetMethod("http://httpcomponents.apache.org");
    // execute method and handle any error responses.
    ...
    InputStream in = get.getResponseBodyAsStream();
    // Process the data from the input stream.
    get.releaseConnection();