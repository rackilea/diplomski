public class ClassToTest {

    private final Service service;
    private final StuffGetter stuffGetter;

    public ClassToTest() {
        this( new Service(), new StuffGetter() );
    }

    public ClassToTest(final Service service, final StuffGetter stuffGetter) {
        this.service = service;
        this.stuffGetter = stuffGetter;
    }

    public User getUser(final int id) {
        final User user = this.service.get( id );
        if( user != null ) {
            user.stuff = getUserStuff( id );
            return user;
        }

        throw new NotFoundException();
    }

    public Stuff getUserStuff( final int id ) {
        return this.stuffGetter.getStuff( id );
    }
}