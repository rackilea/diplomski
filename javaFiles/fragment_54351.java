ConfigurationContext ctx = ConfigurationContextFactory.createConfigurationContextFromFileSystem("repository", null);

NetWS_0Stub stub = new NetWS_0Stub(ctx, aEndPoint);
ServiceClient client = stub._getServiceClient();

Options options = new Options();
options.setTo(new EndpointReference(aEndPoint));
//Added chunking property:
options.setProperty(org.apache.axis2.transport.http.HTTPConstants.CHUNKED, Boolean.FALSE);
client.setOptions(options);
//Engaged rampart module:
client.engageModule("rampart");

return stub;