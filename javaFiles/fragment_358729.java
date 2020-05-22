public class MockSomeClass extends Mockup<SomeClass>{
    public SomeClass it;

    @Mock
    public void $init(DataSource dataSource) {
        Deencapsulation.setField(it, new MockDataSource());
    }
}