Response response1 = client.target(uri)
    .register(new RequestClientFilter(myObjectOne))
    .request()
    .get();
Response response2 = client.target(uri)
    .register(new RequestClientFilter(myObjectTwo))
    .request()
    .get();