String getInstancePublicDnsName(String instanceId) {
    DescribeInstancesResult describeInstancesRequest = ec2.describeInstances();
    List<Reservation> reservations = describeInstancesRequest.getReservations();
    Set<Instance> allInstances = new HashSet<Instance>();
    for (Reservation reservation : reservations) {
      for (Instance instance : reservation.getInstances()) {
        if (instance.getInstanceId().equals(instanceId))
          return instance.getPublicDnsName();
      }
    }
    return null;
}