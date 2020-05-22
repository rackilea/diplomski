AWSCredentials credentials = new AWSCredentials();
AmazonEC2Client client = new AmazonEC2Client(credentials);
CreateVolumeResult request = new  CreateVolumeRequest(java.lang.Integer size,
                       java.lang.String availabilityZone);
CreateVolumeResponse volumeResponse = client.createVolume(request);
AttachVolumeRequest attachRequest = new AttachVolumeRequest(volumeResponse.getVolume().getVolumeId(),  java.lang.String instanceId, java.lang.String device);
client.attachVolume(attachRequest);