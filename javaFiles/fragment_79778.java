@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    public Application(Cluster cluster) {
        this.cluster = cluster;
    }

    @Override
    public void run(String... strings) throws Exception {

    cluster.register(new LatencyTracker() {
                @Override
                public void update(Host host, Statement statement, Exception exception, long newLatencyNanos) {
                    System.out.println(statement);
                }

                @Override
                public void onRegister(Cluster cluster) {

                }

                @Override
                public void onUnregister(Cluster cluster) {

                }
            });
    }

}