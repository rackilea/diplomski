//Fictious is the name of the web service
FictiousStub stub = new FictiousStub("servicelocation/fictiousService.php");

HttpTransportProperties.Authenticator authenticator = new Authenticator();
List<String> authSchemes = new ArrayList<String>();
authSchemes.add(Authenticator.DIGEST);
authenticator.setAuthSchemes(authSchemes);
authenticator.setUsername("admin");
authenticator.setPassword("12345");
authenticator.setPreemptiveAuthentication(true);
Options options = stub._getServiceClient().getOptions();
options.setProperty(org.apache.axis2.transport.http.HTTPConstants.AUTHENTICATE, authenticator);
options.setProperty(org.apache.axis2.transport.http.HTTPConstants.CHUNKED, org.apache.axis2.Constants.VALUE_FALSE);