// Publishing an image to a photo album is easy!
// Just specify the image you'd like to upload and RestFB will handle it from there.
FacebookClient facebookClient = new DefaultFacebookClient(MY_ACCESS_TOKEN);
FacebookType publishPhotoResponse = facebookClient.publish("me/photos", FacebookType.class,
  BinaryAttachment.with("cat.png", getClass().getResourceAsStream("/cat.png")),
  Parameter.with("message", "Test cat"));

out.println("Published photo ID: " + publishPhotoResponse.getId());