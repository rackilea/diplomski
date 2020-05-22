@Configuration
@ConfigurationProperties(prefix = "alias")
public class Alias {

        private List<PropA> name = null;
        public Alias() {}
        public List<PropA> getName() {
            return name;
        }
        public void setName(List<PropA> name) {
            this.name = name;
        }
    }