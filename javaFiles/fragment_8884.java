public class ACLProvider implements org.apache.curator.framework.api.ACLProvider {

private static final String ZK_DIGEST_SCHEME = "digest";

@Override
public List<ACL> getAclForPath(final String path) {

    final String user = System.getProperty("zookeeper.security.user");
    final String password = System.getProperty("zookeeper.security.password");

    Id zkId = null;
    try {
        zkId = new Id(ZK_DIGEST_SCHEME, ZookeeperSecurityUtil.generateDigest(user + ":" + password));
    } catch(final NoSuchAlgorithmException e) {
        e.printStackTrace();
    }

    final ACL acl = new ACL(Perms.ALL, zkId);
    return Collections.singletonList(acl);
}

@Override
public List<ACL> getDefaultAcl() {
    throw new NotImplementedException();
}

}