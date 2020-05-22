do {
    CloseableHttpResponse resp = httpClient.execute(httpGet);
    try {

    // Do what you have to do 
    // but make sure the response gets closed no matter what
    // even if do not care about its content

    } finally {
        resp.close();
    }        
} while (nextPage);