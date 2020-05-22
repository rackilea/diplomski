String accountName = "<your account name>";
String accountKey = "<your account key>";
SharedKeyCredentials credentials = new SharedKeyCredentials(accountName, accountKey);
final ServiceURL serviceURL = new ServiceURL(new URL("http://" + accountName + ".blob.core.windows.net"), StorageURL.createPipeline(credentials, new PipelineOptions()));
String containerName = "<container name>";
ServiceSASSignatureValues values = new ServiceSASSignatureValues()
                .withProtocol(SASProtocol.HTTPS_ONLY) // Users MUST use HTTPS (not HTTP).
                .withExpiryTime(OffsetDateTime.now().plusDays(2)) // 2 days before expiration.
                .withContainerName(containerName)
                .withBlobName(blobName);
ContainerSASPermission permission = new ContainerSASPermission()
                .withRead(true)
                .withAdd(true)
                .withWrite(true);
values.withPermissions(permission.toString());
SASQueryParameters serviceParams = values.generateSASQueryParameters(credentials);
String sas = serviceParams.encode();

String containerUrlWithSAS = String.format(Locale.ROOT, "https://%s.blob.core.windows.net/%s%s",
                accountName, containerName, sas);
HttpPipeline pipeline = new HttpPipelineBuilder().build();
ContainerURL sasContainer = new ContainerURL(new URL(containerUrlWithSAS), pipeline);
sasContainer.getProperties();