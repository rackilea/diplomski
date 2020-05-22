// Three Interfaces:
public interface FooService{
    String foo(String input);
}
public interface BarService{
    String bar(String input);
}
public interface BazService{
    String baz(String input);
}

// Implementation for FooService that uses the other two interfaces
public class FooServiceImpl implements FooService{
    public void setBarService(BarService barService){
        this.barService = barService;
    }
    private BarService barService;
    public void setBazService(BazService bazService){
        this.bazService = bazService;
    }
    private BazService bazService;
    @Override
    public String foo(String input){
        return barService.bar(input)+bazService.baz(input);
    }
}

// And now here's a test for the service implementation with injected mocks
// that do what we tell them to
public class FooServiceImplTest{

    @Test
    public void testFoo(){
        final FooServiceImpl fsi = new FooServiceImpl();

        final BarService barService = EasyMock.createMock(BarService.class);
        EasyMock.expect(barService.bar("foo")).andReturn("bar");
        fsi.setBarService(barService);

        final BazService bazService = EasyMock.createMock(BazService.class);
        EasyMock.expect(bazService.baz("foo")).andReturn("baz");
        fsi.setBazService(bazService);

        EasyMock.replay(barService, bazService);

        assertEquals(fsi.foo("foo"), "barbaz");
    }

}