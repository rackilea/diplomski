public interface VncConfigurator {
    public void configure(Configuration cofiguration) throws ConfigurationException;
}

public class WindowsVncConfigurator implements VncConfgurator {
    public void configure(Configuration cofiguration) throws ConfigurationException {}
}

public class LinuxVncConfigurator implements VncConfgurator {
    public void configure(Configuration cofiguration) throws ConfigurationException {}
}