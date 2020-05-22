@Component
class MyDecorator{
    private final Cache cache;

    public MyDecorator(Cache cache) {
        this.cache = cache;
    }

}