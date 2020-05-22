public void createVolumeWithTags() {
    AmazonEC2 amazonEC2 = AmazonEC2ClientBuilder.standard()
        .withCredentials(new AWSStaticCredentialsProvider(basicAWSCredentials))
        .withRegion(Regions.US_WEST_2)
        .build();

    CreateVolumeRequest createVolumeRequest = new CreateVolumeRequest(10, "us-west-2a");
    CreateVolumeResult createVolumeResult = amazonEC2.createVolume(createVolumeRequest);

    ArrayList<Tag> instanceTags = new ArrayList<Tag>();
    instanceTags.add(new Tag("Name", "HelloWorld"));
    CreateTagsRequest createTagsRequest = new CreateTagsRequest().withTags(instanceTags).withResources(createVolumeResult.getVolume().getVolumeId());

    amazonEC2.createTags(createTagsRequest);
}