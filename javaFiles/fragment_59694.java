STSApi api = ContextBuilder.newBuilder("sts").credentials(keyId,
        key).buildApi(STSApi.class);

AssumeRoleOptions assumeRoleOptions = new AssumeRoleOptions().durationSeconds(3600).externalId(externalId);
final UserAndSessionCredentials credentials = api.assumeRole(roleArn, sessionName, assumeRoleOptions);

Supplier<Credentials> credentialsSupplier = new Supplier<Credentials>() {
    @Override
    public Credentials get() {
        return credentials.getCredentials();
    }
};
BlobStoreContext context = ContextBuilder.newBuilder("aws-s3").credentialsSupplier(credentialsSupplier).buildView(BlobStoreContext.class);