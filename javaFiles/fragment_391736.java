pageObject(String web){

    FirefoxProfile profile = new FirefoxProfile();
    profile.setAssumeUntrustedCertificateIssuer(false);
    profile.setAcceptUntrustedCertificates(false);
    this.driver = new FirefoxDriver(profile);

    // You need to put this line in your constructor
    PageFactory.initElements(this.driver, this);

    // Then follows the rest of your constructor
    ...
}