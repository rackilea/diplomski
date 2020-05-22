@SpringBootApplication
public class So57357544Application {

    public static void main(String[] args) {
        SpringApplication.run(So57357544Application.class, args);
    }

    @Bean
    public IntegrationFlow flow() {
        return IntegrationFlows.from(() -> new Pojo("one", 42, Collections.singletonList("https://localhost/foo"),
                    Collections.singletonList("https://localhost/bar")),
                    e -> e.poller(Pollers.fixedRate(50000)))
                .enrich(enr -> enr.requestChannel("enricherFlow.input")
                        .<List<Pojo>>propertyFunction("productPhotos", msg -> {
                            List<String> photos = msg.getPayload().get(0).getProductPhotos();
                            photos.addAll(msg.getPayload().get(1).getProductPhotos());
                            return photos;
                        })
                        .<List<Pojo>>propertyFunction("marketPhotos", msg -> {
                            List<String> photos = msg.getPayload().get(0).getMarketPhotos();
                            photos.addAll(msg.getPayload().get(1).getMarketPhotos());
                            return photos;
                        }))
                .log()
                .get();
    }

    @Bean
    public IntegrationFlow enricherFlow() {
        return f -> f
                .<Pojo, Pojo> transform(pojo -> new Pojo(pojo.getId(), pojo.getPrice(),
                        pojo.getProductPhotos(),
                        pojo.getMarketPhotos()))
                    .publishSubscribeChannel(exec(), ps -> ps
                            .applySequence(true)
                            .subscribe(f1 -> f1.handle("urlToId", "product").channel("aggregator.input"))
                            .subscribe(f1 -> f1.handle("urlToId", "market").channel("aggregator.input")));
    }

    @Bean
    public IntegrationFlow aggregator() {
        return f -> f.aggregate();
    }

    @Bean
    public Executor exec() {
        ThreadPoolTaskExecutor exec = new ThreadPoolTaskExecutor();
        exec.setCorePoolSize(2);
        return exec;
    }

}

@Component
class UrlToId {

    public Pojo product(Pojo pojo) {
        List<String> productPhotos = pojo.getProductPhotos().stream()
                .map(phot -> phot.substring(phot.lastIndexOf('/')))
                .collect(Collectors.toList());
        return new Pojo(pojo.getId(), pojo.getPrice(), productPhotos, Collections.emptyList());
    }

    public Pojo market(Pojo pojo) {
        List<String> marketPhotos = pojo.getMarketPhotos().stream()
                .map(phot -> phot.substring(phot.lastIndexOf('/')))
                .collect(Collectors.toList());
        return new Pojo(pojo.getId(), pojo.getPrice(), Collections.emptyList(), marketPhotos);
    }

}

class Pojo {

    private final String id;

    private final int price;

    private final List<String> productPhotos = new ArrayList<>();

    private final List<String> marketPhotos = new ArrayList<>();

    public Pojo(String id, int price, List<String> productPhotes, List<String> marketPhotos) {
        this.id = id;
        this.price = price;
        setProductPhotos(productPhotes);
        setMarketPhotos(marketPhotos);
    }

    public String getId() {
        return this.id;
    }

    public int getPrice() {
        return this.price;
    }

    public List<String> getProductPhotos() {
        return new ArrayList<>(this.productPhotos);
    }

    public List<String> getMarketPhotos() {
        return new ArrayList<>(this.marketPhotos);
    }

    public final void setProductPhotos(List<String> photos) {
        if (photos.size() > 0) {
            this.productPhotos.clear();
            this.productPhotos.addAll(photos);
        }
    }

    public final void setMarketPhotos(List<String> photos) {
        if (photos.size() > 0) {
            this.marketPhotos.clear();
            this.marketPhotos.addAll(photos);
        }
    }

    @Override
    public String toString() {
        return "Pojo [id=" + this.id + ", price=" + this.price
                + ", productPhotos=" + this.productPhotos
                + ", marketPhotos=" + this.marketPhotos + "]";
    }

}