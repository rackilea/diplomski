ListObjectsRequest listObjectsRequest = new ListObjectsRequest()
                    .withBucketName(bucketName);
            ObjectListing objectListing;
            do {
                objectListing = s3client.listObjects(listObjectsRequest);
                for (S3ObjectSummary objectSummary
                        : objectListing.getObjectSummaries()) {
                    /** Default Metadata **/
                    Date dtLastModified = objectSummary.getLastModified();
                    String sEtag = objectSummary.getETag();
                    long lSize = objectSummary.getSize();
                    String sStorageClass = objectSummary.getStorageClass();
                    /** To get user defined metadata **/
                    ObjectMetadata objectMetadata = s3client.getObjectMetadata(bucketName, objectSummary.getKey());
                    Map userMetadataMap = objectMetadata.getUserMetadata();
                    Map rowMetadataMap = objectMetadata.getRawMetadata();
                }
                listObjectsRequest.setMarker(objectListing.getNextMarker());
            } while (objectListing.isTruncated());