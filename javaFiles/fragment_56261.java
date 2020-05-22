import java.rmi.RemoteException;

import org.apache.axis2.client.Options;
import org.apache.axis2.client.ServiceClient;
import org.apache.axis2.transport.http.HttpTransportProperties;
import org.wso2.carbon.identity.application.common.model.xsd.InboundAuthenticationConfig;
import org.wso2.carbon.identity.application.common.model.xsd.InboundAuthenticationRequestConfig;
import org.wso2.carbon.identity.application.common.model.xsd.Property;
import org.wso2.carbon.identity.application.common.model.xsd.ServiceProvider;
import org.wso2.carbon.identity.application.mgt.stub.IdentityApplicationManagementServiceStub;

import org.wso2.carbon.identity.oauth.stub.OAuthAdminServiceException;
import org.wso2.carbon.identity.oauth.stub.OAuthAdminServiceStub;
import org.wso2.carbon.identity.oauth.stub.dto.OAuthConsumerAppDTO;

public class IdentityClient {
    private final static String SERVER_URL = "https://localhost:9443/services/";

    public static void main(String[] args) throws RemoteException, OAuthAdminServiceException {

        String appName = "Sample_App_5";
        String appDescription = "Test description";

        System.setProperty("javax.net.ssl.trustStore", "wso2carbon.jks");
        System.setProperty("javax.net.ssl.trustStorePassword", "wso2carbon");

        try {

            OAuthAdminServiceStub stub = new OAuthAdminServiceStub(null,
                    SERVER_URL + "OAuthAdminService");
            IdentityApplicationManagementServiceStub IAMStub = new IdentityApplicationManagementServiceStub(
                    null, SERVER_URL + "IdentityApplicationManagementService");
            ServiceClient client = stub._getServiceClient();
            ServiceClient IAMClient = IAMStub._getServiceClient();
            authenticate(client);

            authenticate(IAMClient);
            ServiceProvider serviceProvider = new ServiceProvider();
            serviceProvider.setApplicationName(appName);
            serviceProvider.setDescription(appDescription);
            IAMStub.createApplication(serviceProvider);

            OAuthConsumerAppDTO consumerApp = new OAuthConsumerAppDTO();
            consumerApp.setApplicationName(appName);
            consumerApp.setOAuthVersion("OAuth-2.0");
            consumerApp.setCallbackUrl("http://localhost:8080/playground2/oauth2client");
            consumerApp.setGrantTypes(
                    "authorization_code implicit password client_credentials refresh_token "
                            + "urn:ietf:params:oauth:grant-type:saml2-bearer iwa:ntlm");

            /* OAuthAdminProxy.registerOAuthApplicationData(consumerApp); */
            stub.registerOAuthApplicationData(consumerApp);
            System.out.println("Application created successfully");
            System.out.println(stub.getOAuthApplicationDataByAppName(appName).getOauthConsumerKey());

            authenticate(IAMClient);

            InboundAuthenticationRequestConfig iaReqConfig = new InboundAuthenticationRequestConfig();
            iaReqConfig.setInboundAuthKey(stub.getOAuthApplicationDataByAppName(appName).getOauthConsumerKey());
            iaReqConfig.setInboundAuthType("oauth2");

            Property property = new Property();
            property.setName("oauthConsumerSecret");
            property.setValue(stub.getOAuthApplicationDataByAppName(appName).getOauthConsumerSecret());
            Property[] properties = { property };
            iaReqConfig.setProperties(properties);

            InboundAuthenticationRequestConfig[] iaReqConfigList = { iaReqConfig };

            InboundAuthenticationConfig ib = new InboundAuthenticationConfig();

            ib.setInboundAuthenticationRequestConfigs(iaReqConfigList);

            serviceProvider = IAMStub.getApplication(appName);
            serviceProvider.setApplicationName(
                    stub.getOAuthApplicationDataByAppName(appName).getApplicationName());
            serviceProvider.setInboundAuthenticationConfig(ib);

            IAMStub.updateApplication(serviceProvider);

            System.out.println("Service Provider created");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void authenticate(ServiceClient client) {
        Options option = client.getOptions();
        HttpTransportProperties.Authenticator auth = new HttpTransportProperties.Authenticator();
        auth.setUsername("admin");
        auth.setPassword("admin");
        auth.setPreemptiveAuthentication(true);
        option.setProperty(org.apache.axis2.transport.http.HTTPConstants.AUTHENTICATE, auth);
        option.setManageSession(true);
    }
}