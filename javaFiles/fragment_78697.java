PostMethod filePost = new PostMethod('https://graph.facebook.com/me/photos');
    filePost.getParams().setBooleanParameter(HttpMethodParams.USE_EXPECT_CONTINUE, false);
    try {
      println("Uploading " + file.getName() + " to 'https://graph.facebook.com/me/photos'");
      Part[] parts = [new FilePart('source', file.getName(), file), new StringPart('access_token', "${facebookData.access_token}"), new StringPart('message', 'some message')]
      filePost.setRequestEntity(new MultipartRequestEntity(parts, filePost.getParams()));
      HttpClient client = new HttpClient();
      client.getHttpConnectionManager().getParams().setConnectionTimeout(5000);
      int status = client.executeMethod(filePost);
      if (status == HttpStatus.SC_OK) {
        println("Upload complete, response=" + filePost.getResponseBodyAsString());
      } else {
        println("Upload failed, response=" + HttpStatus.getStatusText(status));
        // Create response
        StringBuilder notificationsSendResponse = new StringBuilder();
        byte[] byteArrayNotifications = new byte[4096];
        for (int n; (n = filePost.getResponseBodyAsStream().read(byteArrayNotifications)) != -1;) {
          notificationsSendResponse.append(new String(byteArrayNotifications, 0, n));
        }
        String notificationInfo = notificationsSendResponse.toString();
      }
    } catch (Exception ex) {
      println("ERROR: " + ex.getClass().getName() + " " + ex.getMessage());
      ex.printStackTrace();
    } finally {
      filePost.releaseConnection();
    }