interface IEnvironmentOption {
    public static final String OPTION_NAME = "-t";

    public void setOption(String name, String value);

    public String getOption(String name);
}

class EnvironmentOptions implements IEnvironmentOption {
    private Properties envProperties;

    @Override
    public void setOption(String name, String value) {
        envProperties.setProperty(name, value);
    }

    @Override
    public String getOption(String name) {
        return envProperties.getProperty(name);
    }
}