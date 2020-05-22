public String GetFodlerSize() {

        String str = "";
        int Finalsize = 0;

        AWSCredentials credentials = new BasicAWSCredentials(accesskey,
                secretkey);
        AmazonS3 conn = new AmazonS3Client(credentials);

        ListObjectsRequest listObjectsRequest = new ListObjectsRequest()
                .withBucketName(BucketName).withPrefix(FolderName);
        ObjectListing objectListing;

        do {
            objectListing = conn.listObjects(listObjectsRequest);
            for (S3ObjectSummary objectSummary : objectListing
                    .getObjectSummaries()) {

                str = (objectSummary.getSize() + "");
                int size = Integer.parseInt(str);

                Finalsize = Finalsize + size;

            }
            listObjectsRequest.setMarker(objectListing.getNextMarker());
        } while (objectListing.isTruncated());


        return FolderSize;
    }