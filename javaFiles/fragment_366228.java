@Service
public class CacheableService {
    @Cacheable(value="default")
    public int sum(int i,int q){
        System.out.println("called");
        return i+q;
    }
}