public class Foo { /* ... */}
public class FooDto { /* ... */}

public class FooService {

    public FooResults getSomeResults() { /* ... */ }
}

public class FooMapper {

    private final FooService service;

    public FooMapper(FooService service) {
        this.service = service;
    }

    public FooDto convert(Foo foo) { 

        FooResults results = service.getSomeResults();

        // ... use results ...
    }
}