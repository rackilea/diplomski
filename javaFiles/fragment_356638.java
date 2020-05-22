@Produces 
IdentityConfiguration produceIdentityManagementConfiguration() {
    IdentityConfigurationBuilder builder = new IdentityConfigurationBuilder();

    builder
        .named("default")
        .stores()
        .jpa().addCredentialHandler(EmailPasswordCredentialHandler.class)
        .supportAllFeatures().supportType(UserAccount.class);

    return builder.build();