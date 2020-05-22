public class LdapServerRule extends ExternalResource {
private static final Log LOG = LogFactory
        .getLog(LdapServerRule.class);

public static final String DefaultDn = "cn=Directory Manager";
public static final String DefaultPassword = "password";
private String baseDn;
private String dn;
private String password;
private String lDiffPath;
private InMemoryDirectoryServer server;
private int listenPort;

public LdapServerRule(String baseDn, String lDiffPath) {
    this(baseDn, lDiffPath, 0);
}


public LdapServerRule(String baseDn, String lDiffPath, int listenPort) {
    this.lDiffPath = lDiffPath;
    this.baseDn = baseDn;
    this.dn = DefaultDn;
    this.password = DefaultPassword;
    this.listenPort = listenPort;

}

@Override
protected void before() {
    start();
}

@Override
protected void after() {
    stop();
}

public int getRunningPort() {
    return getServer().getListenPort();
}

private void start() {
    InMemoryDirectoryServerConfig config;

    try {
        LOG.info("LDAP server " + toString() + " starting...");
        config = new InMemoryDirectoryServerConfig(getBaseDn());
        config.addAdditionalBindCredentials(getDn(),
                getPassword());
        config.setSchema(null);
        config.setListenerConfigs(
                InMemoryListenerConfig.createLDAPConfig("LDAP", getListenPort()));
        setServer(new InMemoryDirectoryServer(config));

        getServer().importFromLDIF(true, getLDiffPath());
        getServer().startListening();
        LOG.info("LDAP server " + toString() + " started. Listen on port " + getServer().getListenPort());
    } catch (Exception e) {
        throw new RuntimeException(e);
    }

}

private void stop() {
    server.shutDown(true);
    LOG.info("LDAP server " + toString() + " stopped");
}

public String getBaseDn() {
    return baseDn;
}

public String getDn() {
    return dn;
}

public String getPassword() {
    return password;
}

public InMemoryDirectoryServer getServer() {
    return server;
}

public void setServer(InMemoryDirectoryServer server) {
    this.server = server;
}

public String getLDiffPath() {
    return lDiffPath;
}

public int getListenPort() {
    return listenPort;
}

@Override
public String toString() {
    return com.google.common.base.Objects.toStringHelper(this)
            .add("baseDn", baseDn)
            .add("listenPort", listenPort)
            .toString();
}