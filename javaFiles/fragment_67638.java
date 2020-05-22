CreateVolumeRequest createVolumeRequest = new CreateVolumeRequest()
    .withAvailabilityZone("my instance's AZ") // The AZ in which to create the volume.
    .withSize(2); // The size of the volume, in gigabytes.

CreateVolumeResult createVolumeResult = ec2.createVolume(createVolumeRequest);

AttachVolumeRequest attachRequest = new AttachVolumeRequest()
    .withInstanceId("my instance id");
    .withVolumeId(createVolumeResult.getVolume().getVolumeId());

AttachVolumeResult attachResult = ec2.attachVolume(attachRequest);