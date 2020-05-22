try {
            String authCookie = null;
            ConfigurationContext ctx = ConfigurationContextFactory.createConfigurationContextFromFileSystem(null, null);
            AuthenticationAdminStub authstub = new AuthenticationAdminStub(ctx, "https://localhost:9443/services`enter code here`/AuthenticationAdmin");
            ServiceClient client = authstub._getServiceClient();
            Options options = client.getOptions();`enter code here`
            options.setManageSession(true);
            options.setProperty(org.apache.axis2.transport.http.HTTPConstants.COOKIE_STRING, authCookie);
            //set trust store properties required in SSL communication.
            System.setProperty("javax.net.ssl.trustStore", RemoteUMSampleConstants.TRUST_STORE_PATH);
            System.setProperty("javax.net.ssl.trustStorePassword", RemoteUMSampleConstants.TRUST_STORE_PASSWORD);
            authstub.login("admin", "admin", "localhost");
            authCookie = (String) authstub._getServiceClient().getServiceContext().getProperty(
                    HTTPConstants.COOKIE_STRING);


            IdentityApplicationManagementServiceStub stub = new IdentityApplicationManagementServiceStub(
                    "https://localhost:9443/services/IdentityApplicationManagementService");
            ServiceClient e = stub._getServiceClient();
            Options option = e.getOptions();
            option.setManageSession(true);
            option.setProperty("Cookie", authCookie);

            ServiceProvider serviceProvider = new ServiceProvider();
            serviceProvider.setApplicationName("testName");
            serviceProvider.setDescription("testDescription");

            stub.createApplication(serviceProvider);
}catch (Exception e){
            System.out.print(e);
}