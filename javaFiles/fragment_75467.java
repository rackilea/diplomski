// Instantiating rdsClient directly is deprecated, use AmazonRDSClientBuilder.
// AmazonRDSClient rdsClient = new AmazonRDSClient(/*add your credentials and the proper constructor overload*/);

AmazonRDS rdsClient = AmazonRDSClientBuilder.defaultClient();

DescribeDBInstancesRequest request = new DescribeDBInstancesRequest();
DescribeDBInstancesResult result = rdsClient.describeDBInstances(request);
List<DBInstance> list = result.getDBInstances();
System.out.println("list length = " + list.size());