public void printRdsSecret() throws IOException {
    String secretName = "mySecretName";

    System.out.println("Requesting secret...");
    AWSSecretsManager client = AWSSecretsManagerClientBuilder.standard().build();

    GetSecretValueRequest getSecretValueRequest = new GetSecretValueRequest().withSecretId(secretName);

    GetSecretValueResult getSecretValueResult = client.getSecretValue(getSecretValueRequest);

    System.out.println("secret retrieved ");
    final String secretBinaryString = getSecretValueResult.getSecretString();
    final ObjectMapper objectMapper = new ObjectMapper();

    final HashMap<String, String> secretMap = objectMapper.readValue(secretBinaryString, HashMap.class);

    String url = String.format("jdbc:postgresql://%s:%s/dbName", secretMap.get("host"), secretMap.get("port"));
    System.out.println("Secret url = "+url);
    System.out.println("Secret username = "+secretMap.get("username"));
    System.out.println("Secret password = "+secretMap.get("password"));
 }