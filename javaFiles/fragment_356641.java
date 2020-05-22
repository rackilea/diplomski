ByteBuffer buf = ByteBuffer.wrap(os.toByteArray());
GcsFilename gcsfileName = new GcsFilename(bucketName, bucketFileName);
//bucketFileName =  your file name
GcsFileOptions options = new GcsFileOptions.Builder().mimeType("text/plain").build();
GcsOutputChannel outputChannel = gcsService.createOrReplace(gcsfileName, options);
outputChannel.write(buf);
outputChannel.close();