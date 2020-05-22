@Module
public class MyModule {
    @Provides
    @Singleton
    MockData provideMockData() {
       return new MockData(Arrays.asList("A", "B", "C"));
    }

    @Provides
    OtherClass provideOtherClass(MockData mockData) {
       return new OtherClass(mockData);
    }
}

public class MockData {

    private List<String> list;

    public MockData(List<String> list){
        this.list = list;
    }

    public List<String> getList() {
        return list;
    }
}