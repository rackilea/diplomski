AmazonEC2Client ec2 = new AmazonEC2Client(cred);
    DescribeInstancesResult describeInstancesResult = ec2.describeInstances(new DescribeInstancesRequest().withInstanceIds(clusterInstanceIds));
    List<Reservation> reservations = describeInstancesResult.getReservations();
    for (Reservation res : reservations) {
        for (GroupIdentifier group : res.getGroups()) {
            if (group.getGroupName().equals("ElasticMapReduce-master")) { // yaaaaaaaaah, Wahay!
                masterDNS = res.getInstances().get(0).getPublicDnsName();
            }
        }
    }