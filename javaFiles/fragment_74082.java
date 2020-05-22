`AWSCredentials credentials;
    try {
        credentials = new ProfileCredentialsProvider().getCredentials();
    } catch (Exception e) {
        throw new AmazonClientException("Cannot load the credentials from the credential profiles file. "
                + "Please make sure that your correct credentials file is at the correct "
                + "location (/Users/userid/.aws/credentials), and is in valid format.", e);
    }
    AWSSecurityTokenServiceClient stsClient = new AWSSecurityTokenServiceClient(credentials);

    AssumeRoleRequest assumeRequest = new AssumeRoleRequest().withRoleArn(ROLE_ARN).withDurationSeconds(3600)
            .withRoleSessionName("demo");

    AssumeRoleResult assumeResult = stsClient.assumeRole(assumeRequest);

    BasicSessionCredentials temporaryCredentials = new BasicSessionCredentials(
            assumeResult.getCredentials().getAccessKeyId(), assumeResult.getCredentials().getSecretAccessKey(),
            assumeResult.getCredentials().getSessionToken());