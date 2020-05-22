public SecurityGroup findOneSecurityGroupByName(String securityGroupName) {
    DescribeSecurityGroupsRequest securityRequest = new DescribeSecurityGroupsRequest();
    securityRequest.setGroupNames(Arrays.asList(securityGroupName));
    DescribeSecurityGroupsResult securityDescription = ec2.describeSecurityGroups(securityRequest);
    return securityDescription.getSecurityGroups().get(0);
}