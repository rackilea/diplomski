public void awsTokenManager() {
        System.out.println("Inside awsTokenManager method");
        STSAssumeRoleSessionCredentialsProvider stsAssumeRoleSessionCredentialsProvider = new STSAssumeRoleSessionCredentialsProvider.Builder(iAM_ROLE_ARN_TO_ASSUME, "us-east-1b")
                .withStsClient(AWSSecurityTokenServiceClientBuilder.standard().build())
                .withRoleSessionDurationSeconds(900)
                .build();
        System.out.println("SessionCredentials awsaccesskeyid is - " + stsAssumeRoleSessionCredentialsProvider.getCredentials().getAWSAccessKeyId());
        System.out.println("SessionCredentials awsaccesskeyid is - " + stsAssumeRoleSessionCredentialsProvider.getCredentials().getAWSSecretKey());
        System.out.println("SessionCredentials awsaccesskeyid is - " + stsAssumeRoleSessionCredentialsProvider.getCredentials().getSessionToken());
        }