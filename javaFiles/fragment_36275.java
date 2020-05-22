NovaApi novaApi = ContextBuilder
        .newBuilder("openstack-nova")
        .credentials("username", "api_key")
        .buildApi(NovaApi.class);

Ingress ingress = Ingress.builder().fromPort(80).toPort(80).ipProtocol(IpProtocol.TCP).build();

SecurityGroupApi securityGroupApi = novaApi.getSecurityGroupExtensionForZone("RegionOne").get();
SecurityGroup securityGroup = securityGroupApi.createWithDescription("name", "description");
SecurityGroupRule rule = securityGroupApi.createRuleAllowingCidrBlock(securityGroup.getName(), ingress, "0.0.0.0/0");
securityGroupApi.delete(securityGroup.getId());