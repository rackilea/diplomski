public class TestJackson {
    public static void main(String[] args) throws IOException {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        MyConfig myConfig = new MyConfig();
        ObjectReader objectReader = mapper.readerForUpdating(myConfig);
        objectReader.readValue(new File("misc/a.yaml"));
        objectReader.readValue(new File("misc/b.yaml"));
        System.out.println(myConfig);
    }

    @Data
    public static class MyConfig {
        @JsonMerge
        private Pool pool;
    }

    @Data
    public static class Pool {
        private Integer idleConnectionTestPeriodSeconds;
        private Integer idleMaxAgeInMinutes;
        private Integer partitionCount;
        private Integer acquireIncrement;
        private String username;
        private String password;
    }
}