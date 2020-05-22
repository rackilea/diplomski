ConfigurationBuilder twitterConfigBuilder = new ConfigurationBuilder();
    twitterConfigBuilder.setDebugEnabled(true);
    twitterConfigBuilder.setOAuthConsumerKey("consumerkey");
    twitterConfigBuilder.setOAuthConsumerSecret("consumersecret");
    twitterConfigBuilder.setOAuthAccessToken("accesstoken");
    twitterConfigBuilder.setOAuthAccessTokenSecret("accesstokensecret");

    Twitter twitter = new TwitterFactory(twitterConfigBuilder.build()).getInstance();
    String statusMessage = "Hey I am posting 2 images of xyz event";
    File imagefile1 = new File("/images/image_1.jpg");
    File imagefile2 = new File("/images/image_2.jpg");

    long[] mediaIds = new long[2];
    UploadedMedia media1 = twitter.uploadMedia(imagefile1);
    mediaIds[0] = media1.getMediaId();
    UploadedMedia media2 = twitter.uploadMedia(imagefile2);
    mediaIds[1] = media2.getMediaId();

    StatusUpdate statusUpdate = new StatusUpdate(statusMessage);
    statusUpdate.setMediaIds(mediaIds);
    Status status = twitter.updateStatus(statusUpdate);