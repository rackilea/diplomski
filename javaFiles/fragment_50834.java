@ManagedResource(
        objectName = "com.xormedia.aqua.mbean:name=AuthenticationServer",
        description = "AuthenticationServerSummary",
        log = true,
        logFile = "jmx.log",
        currencyTimeLimit = 1)
public class AuthenticationServerSummaryMbean {
    private String ip;
    private String port;

    @ManagedAttribute(description = "IP Address", currencyTimeLimit = 1)
    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    @ManagedAttribute(description = "Port number", currencyTimeLimit = 1)
    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }
}