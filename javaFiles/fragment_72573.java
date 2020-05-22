public class Foo {

    @Inject
    public Foo(@Named("bar") Jar bar, @Named("tar") Jar tar) {
    }
}

public interface Jar {}
public class Bar extends Jar {}
public class Tar extends Jar {}