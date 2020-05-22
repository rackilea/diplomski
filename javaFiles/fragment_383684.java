@Test
public void findsAllSecurityGroups() {
    assertThat(firewall.findAllSecurityGroups().size(), is(greaterThan(0)));
}

@Test
public void findsDefaultSecurityGroupByName() {
    SecurityGroup defaultGroup = firewall.findOneSecurityGroupByName("default");
    assertThat(defaultGroup.getGroupName(), is(equalTo("default")));
}

@Test(expected = AmazonServiceException.class)
public void throwsExceptionWhenfindingNonExistentSecurityGroup() {
    firewall.findOneSecurityGroupByName("inexistent");
}