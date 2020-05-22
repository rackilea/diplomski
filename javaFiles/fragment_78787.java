@Resource(mappedName = "org.glassfish.embeddable.CommandRunner") CommandRunner commandRunner;

public void configureLoginRealm() {
    CommandResult commandResult = commandRunner.run("create-auth-realm", "--classname=com.blah.blah.SecureJDBCRealm", "--property=jaas-context= secureJDBCRealm", "secure-JDBC-realm");
    log.debug(commandResult.getExitStatus().toString() + " " + commandResult.getOutput());
    Throwable throwable = commandResult.getFailureCause();
    if (throwable != null) {
        log.error(throwable.getMessage(), throwable);
    }
}