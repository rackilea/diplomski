AmazonEC2 ec2 = new AmazonEC2Client(new StaticCredentialsProvider(new BasicAWSCredentials("your-aws-access-key-here", "your-aws-secret-here")));
    DescribeInstancesRequest request = new DescribeInstancesRequest();

    Filter filter = new Filter()
            .withName("availability-zone")
            .withValues("us-east-1a");

    request.withFilters(filter);

    DescribeInstancesResult result = ec2.describeInstances(request);
    List<Reservation> reservations = result.getReservations();