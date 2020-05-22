public Integer getInstanceStatus(String instanceId) {
    DescribeInstancesRequest describeInstanceRequest = new DescribeInstancesRequest().withInstanceIds(instanceId);
    DescribeInstancesResult describeInstanceResult = ec2.describeInstances(describeInstanceRequest);
    InstanceState state = describeInstanceResult.getReservations().get(0).getInstances().get(0).getState();
    return state.getCode();
}