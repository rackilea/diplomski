ObjectMetadata metadata = new ObjectMetadata();
metadata.setContentEncoding("UTF-8");
size = inputStream.available();
metadata.setContentLength(size);
TransferManager transferManager = new TransferManager(credentialsProvider);
Upload upload = transferManager.upload(bucket_name, key, images3, metadata);
upload.waitForCompletion();