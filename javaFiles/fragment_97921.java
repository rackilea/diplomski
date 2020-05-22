@Component
@ConfigurationProperties(prefix = "my", ignoreUnknownFields = false)

public class CountryBasedProps {

    Map<String,CountryProps> config = new HashMap<>();


    public Map<String, CountryProps> getConfig() {
        return config;
    }

    public void setConfig(Map<String, CountryProps> config) {
        this.config = config;
    }

    public static class CountryProps{
        String name;
        String address;

        /*
           other properties, with getters/setters
         */

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        @Override
        public String toString() {
            return "CountryProps{" +
                    "name='" + name + '\'' +
                    ", address='" + address + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "CountryBasedProps{" +
                "config=" + config +
                '}';
    }
}