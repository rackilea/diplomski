public static List<String> getObjectsListFromS3(AmazonS3 s3, String bucket, String prefix) {
    final String delimiter = "/";
    if (!prefix.endsWith(delimiter)) {
        prefix = prefix + delimiter;
    }

    List<String> paths = new LinkedList<>();
    ListObjectsRequest request = new ListObjectsRequest().withBucketName(bucket).withPrefix(prefix);

    ObjectListing result;
    do {
        result = s3.listObjects(request);

        for (S3ObjectSummary summary : result.getObjectSummaries()) {
            // Make sure we are not adding a 'folder'
            if (!summary.getKey().endsWith(delimiter)) {
                paths.add(summary.getKey());
            }
        }
        request.setMarker(result.getMarker());
    }
    while (result.isTruncated());

    return paths;
}