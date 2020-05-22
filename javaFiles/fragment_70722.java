RestClient<YourObject> restClient = new RestClient<>(YourObject.class);
restClient.execute();
Thread.sleep(5000); //You can do this other better ways, but just as example I'm doing this...

//After the execution you get your objects:
WebApiReturn return = getWebApiReturn();
YourObject object = (YourObject) restClient.getObjectResponse();