public class LoadableBuilderTest extends LoadableBuilder {
    Mockery context = new Mockery();
    final LoadableFactory mockFactory = context.mock(ILoadableFactory.class); //This is the interface you'll need to make which LoadableFactory implements. It will need the create() method.

    @Override
    protected ILoadableFactory getFactory(){
        return mockFactory;
    }

    @Test
    public void shouldCallCreateProperly(){
        context.checking(new Expectations(){{
            oneOf(mockFactory).create(arg1,arg2);
        }});
        //Do your stuff to test that create() was called.
    }
}