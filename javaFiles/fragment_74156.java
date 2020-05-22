List<S3ObjectSummary> keyList = new ArrayList<S3ObjectSummary>();
ObjectListing objects = s3.listObjects("bucket.new.test");
keyList.addAll(objects.getObjectSummaries());

while (objects.isTruncated()) {
    objects = s3.listNextBatchOfObjects(objects);
    keyList.addAll(objects.getObjectSummaries());
}