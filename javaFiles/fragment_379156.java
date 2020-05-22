@Configuration
@ConfigurationProperties(prefix = "system")
public class SystemProperties {

    private List<Locator> locators;

    public List<Locator> getLocators() {
        return locators;
    }

    public void setLocators(List<Locator> locators) {
        this.locators = locators;
    }

    public static class Locator {
        private String name;
        private List<String> ports;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public List<String> getPorts() {
            return ports;
        }

        public void setPorts(List<String> ports) {
            this.ports = ports;
        }

    }

}