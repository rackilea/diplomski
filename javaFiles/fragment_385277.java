public interface RecordVisitor<T> {
    T visitFoo(FooRecord foo);
    T visitBar(BarRecord foo);
    ...
}

public abstract class BaseRecord {
    public abstract <T> T accept(RecordVisitor<T> visitor);
}

public class FooRecord extends BaseRecord {
    @Override
    public <T> T accept(RecordVisitor<T> visitor) {
        return visitor.visitFoo(this);
    }
}

public class BarRecord extends BaseRecord {
    @Override
    public <T> T accept(RecordVisitor<T> visitor) {
        return visitor.visitBar(this);
    }
}