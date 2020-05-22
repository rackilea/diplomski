public interface Foo<T> {

         Class<T> getClassFromType();
    }

@Component
public class FooIntegerImpl implements Foo<Integer>{


    @Override
    public Class<Integer> getClassFromType() {
        return Integer.class;
    }
}

@Component
public class FooStringImpl implements Foo<String>{

    @Override
    public Class<String> getClassFromType() {
        return String.class;
    }
}

@Component
public class Test {

    private List<Foo> foo;

    @Autowired
    public Test(List<Foo> foo) {
        this.foo = foo;
    }

}