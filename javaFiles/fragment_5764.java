public class LambdaFunctionHandler implements RequestStreamHandler  {
    public void handleRequest(InputStream input, OutputStream output, Context context) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        AmazonS3 s3Client = new AmazonS3Client(
                new EnvironmentVariableCredentialsProvider());
        try {

            // Need to deserialize JSON data ourselves in Lambda streaming mode
            String data = getJSONInputStream(input);
            context.getLogger().log("JSON data:\n'" + data + "'\n");            
            context.getLogger().log("Deserialize JSON data to object\n");
            ImageRequest request  = mapper.readValue(data, ImageRequest.class);

            context.getLogger().log(String.format("Downloading S3 object: %s %s\n", 
                    request.getBucket(), request.getKey()));
            S3Object s3object = s3Client.getObject(new GetObjectRequest(
                    request.getBucket(), request.getKey()));
            context.getLogger().log("Content-Type: "  + 
                    s3object.getObjectMetadata().getContentType() + "\n");
            InputStream in = s3object.getObjectContent();
            int b = 0;
            byte[] buf = new byte[2048];
            context.getLogger().log("Writing image on output\n");
            while ((b = in.read(buf)) > -1) {
                output.write(buf, 0, b);
            }

        } catch (AmazonServiceException e) {
            System.out.println("Error Message: " + e.getMessage());
        }   
    }

  private String getJSONInputStream(InputStream input) throws IOException {
      BufferedReader reader = new BufferedReader(new InputStreamReader(input));
      String data = "";
      String line;
      while ((line = reader.readLine()) != null) {
                data += line;
      }
      return data;
  }
}