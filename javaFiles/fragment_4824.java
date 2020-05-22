// This is a "global" API (meaning it is visible to all layers). This is ok as
// it is a specification and not an implementation.
public interface FooWriter {
    void write(Foo foo);
}

// DAO layer
public class FooDaoImpl {
    ...
    public void streamBigQueryTo(FooWriter fooWriter, ...) {
        ...
        for (Foo foo: executeQueryThatReturnsLotsOfFoos(...)) {
            fooWriter.write(foo);
            evict(foo);
        }
    } 
    ...
}

// UI layer
public class FooUI {
    ...
    public void dumpCsv(...) {
        ...
        fooBusiness.streamBigQueryTo(new CsvFooWriter(request.getOutputStream()), ...);
        ...
    }
}

// Business layer
public class FooBusinessImpl {
    ...
    public void streamBigQueryTo(FooWriter fooWriter, ...) {
        ...
        if (user.canQueryFoos()) {
            beginTransaction();
            fooDao.streamBigQueryTo(fooWriter, ...);
            auditAccess(...);
            endTransaction();
        }
        ...
    }
}