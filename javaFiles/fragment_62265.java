public interface MyObject {
    @Value("#{target.age}")
    int age();

    @Value("#{target.weight}")
    int weight;
}