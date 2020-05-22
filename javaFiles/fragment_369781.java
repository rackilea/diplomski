public class SmtpIntegrationForm extends IntegrationCommonSection {


    private static final By integrationServerBy = Locators.findBy("settings_page_integrations_page_integration_server_name_txt");
    private static final By integrationPortBy = Locators.findBy("settings_page_integrations_page_integration_port_txt");
    private static final By integrationFromAddressBy = Locators.findBy("settings_page_integrations_page_integration_from_address_txt");

    SmtpIntegrationForm(DriverWrapper driver){
        super(driver);
    }

    SmtpIntegrationForm setIntegrationServer(String server){
        setText(integrationServerBy, server);
        return this;
    }

    SmtpIntegrationForm setIntegrationPort(String port){
        setText(integrationPortBy, port);
        return this;
    }

    SmtpIntegrationForm setIntegrationFromAddress(String address){
        setText(integrationFromAddressBy, address);
        return this;
    }

    SmtpIntegrationForm chooseIntegration(IntegrationType integrationType){
        clickButton(By.cssSelector("li[class~='qa_" + integrationType.value + "']"));
        return this;
    }
}