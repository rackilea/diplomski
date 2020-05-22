try {
    TransferManager tm = TransferManagerBuilder.standard()
            .withS3Client(s3Client)
            .build();

    // TransferManager processes all transfers asynchronously,
    // so this call returns immediately.
    Upload upload = tm.upload(bucketName, "movie.mov", 
        new File(picturePath + "/" + "movie.mov"));
    System.out.println("Object upload started");

    // Optionally, wait for the upload to finish before continuing.
    upload.waitForCompletion();
    System.out.println("Object upload complete");
} catch (AmazonServiceException e) {
    // The call was transmitted successfully, but Amazon S3 couldn't process 
    // it, so it returned an error response.
    e.printStackTrace();
} catch (SdkClientException e) {
    // Amazon S3 couldn't be contacted for a response, or the client
    // couldn't parse the response from Amazon S3.
    e.printStackTrace();
}