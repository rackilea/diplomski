@Repository
public class DaoObjectImpl implements DaoObject {
    @Cacheable(value = CacheConstants.FORM_TEMPLATE)
    public int getRandomInt(){
        return new Random().nextInt();
    }

    @Override
    public int getCachedNumber() {
        return getRandomInt();
    }
}