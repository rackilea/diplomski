public final class JacksonTest {

    static final class ExampleBean {

        private String id;
        private String bar;

        @JsonProperty("donotwanttoseethis")
        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getBar() {
            return bar;
        }

        public void setBar(String bar) {
            this.bar = bar;
        }

    }

    public interface MongoIdMixIn {

        @JsonProperty("_id") String getId();

    }

    public interface OrientIdMixIn {

        @JsonProperty("@rid") String getId();

    }

    private final static Logger LOG = LoggerFactory.getLogger();

    public static void main(String[] args) throws JsonProcessingException {
        ExampleBean bean = new ExampleBean();
        bean.setId("1234");
        bean.setBar("lala");

        ObjectMapper m2 = new ObjectMapper();
        m2.addMixInAnnotations(ExampleBean.class, MongoIdMixIn.class);
        LOG.info(m2.writeValueAsString(bean));

        ObjectMapper m3 = new ObjectMapper();
        m3.addMixInAnnotations(ExampleBean.class, OrientIdMixIn.class);
        LOG.info(m3.writeValueAsString(bean));
    }

}