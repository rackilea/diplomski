@Component
public class DataService {
    @Cacheable(value="movieFindCache", key="#p0")
    public String findByDirector(String name) {
        return "hello";
    }
}