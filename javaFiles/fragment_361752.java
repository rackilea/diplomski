public class SignServiceImpl implements SignService {

    private String awsBucket;
    private String awsAccessKey;
    private String awsSecretKey;

    SignServiceImpl(AmazonConfiguration amazon) {
        awsSecretKey = amazon.getSecret();
        awsAccessKey = amazon.getAccess();
        awsBucket = amazon.getBucket();
    }

    @Override
    public String signRequest(String contentType) {
        final String randomFileName = createRandomName();

        String policy = createPolicy(randomFileName, contentType);

        SignRequest signRequest = new SignRequest();
        signRequest.setAwsAccessKeyId(awsAccessKey);
        signRequest.setPolicy(policy);
        signRequest.setSignature(ServiceUtils.signWithHmacSha1(awsSecretKey, policy));
        signRequest.setBucket(awsBucket);
        signRequest.setKey(randomFileName);
        signRequest.setAcl("public-read");
        signRequest.setContentType(contentType);
        signRequest.setExpires(createExpireTime().toString());
        signRequest.setSuccessActionStatus("201");

        return createJsonString(signRequest);
    }

    private String createPolicy(String randomFileName, String contentType) {
        try {
            String[] conditions = {
                S3Service.generatePostPolicyCondition_Equality("bucket", awsBucket),
                S3Service.generatePostPolicyCondition_Equality("key", randomFileName),
                S3Service.generatePostPolicyCondition_Equality("acl", "public-read"),
                S3Service.generatePostPolicyCondition_Equality("expires", createExpireTime().toString()),
                S3Service.generatePostPolicyCondition_Equality("content-Type", contentType),
                S3Service.generatePostPolicyCondition_Equality("success_action_status", "201"),
                S3Service.generatePostPolicyCondition_AllowAnyValue("cache-control")
            };

            String policyDocument = "{\"expiration\": \"" + ServiceUtils.formatIso8601Date(createExpireTime()) + "\", \"conditions\": [" + ServiceUtils.join(conditions, ",") + "]}";

            return ServiceUtils.toBase64(policyDocument.getBytes(Constants.DEFAULT_ENCODING));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return null;
    }

    private String createRandomName() {
        return UUID.randomUUID().toString();
    }

    private Date createExpireTime() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.HOUR, 24);

        return cal.getTime();
    }

    private String createJsonString(SignRequest request) {
        ObjectMapper mapper = new ObjectMapper();
        String json = null;

        try {
            json = mapper.writeValueAsString(request);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return json;
    }
}