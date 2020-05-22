interface Face<R> {

    List<? extends R> create(List<? extends R> resources);
}

public interface Type {
}

public class Impl implements Face<Type> {

    @Override
    public List<? extends Type> create(List<? extends Type> resources) {            
    }
}

public class Impl2 implements Face<Object> {

    @Override
    public List<? extends Object> create(List<? extends Object> resources) {
    }
}