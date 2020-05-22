ObjectMapper objectMapper = new ObjectMapper(); 
 byte[] bytesToWrite = objectMapper.writeValueAsBytes(yourObject)

 ObjectMetadata omd = new ObjectMetadata();
 omd.setContentLength(bytesToWrite.length);
 transferManager.upload(bucketName, filename, new ByteArrayInputStream(bytesToWrite), omd);