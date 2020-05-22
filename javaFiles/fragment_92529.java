public class S3Prefix {

    private static final AmazonS3Client s3 = new AmazonS3Client();

    public static void main(String[] args) {
        Arrays.asList(null, "test1", "test1/").forEach(S3Prefix::listPrefix);
    }

    public static void listPrefix(String prefix) {
        System.out.println("Listing prefix '" + prefix + "'");
        final ListObjectsV2Result result = s3.listObjectsV2(new ListObjectsV2Request()
                .withPrefix(prefix)
                .withBucketName("raniz-prefix-test")
                .withDelimiter("/"));

        System.out.println("\tCommon prefixes");
        result.getCommonPrefixes().forEach(p -> System.out.println("\t\t" + p));

        System.out.println("\tKeys");
        result.getObjectSummaries().forEach(s -> System.out.println("\t\t" + s.getKey()));
    }
}