// Instantiate a builder for your client and set required properties
ClientBuilder builder = Clients.builder();    

// Build the client instance that you will use throughout your application code
Client client = builder.build();

Tenant tenant = client.getCurrentTenant();
ApplicationList applications = tenant.getApplications(
        Applications.where(Applications.name().eqIgnoreCase("My Application"))
);

Application application = applications.iterator().next();


//Capture the username and password, such as via an SSL-encrypted web HTML form. 
//We'll just simulate a form lookup and use the values we used above:
String usernameOrEmail = "tk421@stormpath.com";
String rawPassword = "Changeme1";

//Create an authentication request using the credentials
AuthenticationRequest request = new UsernamePasswordRequest(usernameOrEmail, rawPassword);

//Now let's authenticate the account with the application:
try {
    AuthenticationResult result = application.authenticateAccount(request);
    Account account = result.getAccount();
} catch (ResourceException ex) {
    System.out.println(ex.getStatus() + " " + ex.getMessage());
}