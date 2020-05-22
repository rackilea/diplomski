@Component
@ConfigurationProperties(prefix = "app")
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.NONE)
public class StatusProperties {

    private List<Status> statuses = new ArrayList<>();

    public List <Status> getStatuses () {
        return statuses;
    }

    public void setStatuses (List <Status> statuses) {
        this.statuses = statuses;
    }

    public static class Status {
        private String id;
        private String title;

        public String getId () {
            return id;
        }

        public void setId (String id) {
            this.id = id;
        }

        public String getTitle () {
            return title;
        }

        public void setTitle (String title) {
            this.title = title;
        }
    }
}