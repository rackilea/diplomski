public enum JBossVersion {

    UNKNOWN(""),
    JBOSS_4_2_3("4.2.3"),
    JBOSS_6_2("6.2");

    private String version;

    private JBossVersion(String version) {
        this.version = version;
    }

    public String getVersion() {
        return version;
    }

}