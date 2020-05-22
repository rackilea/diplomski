@Component
public class TestClassWithInteger {

    private MyClass<Integer, Integer> myClass;

    @Autowired
    public TestClassWithInteger(MyClass<Integer, Integer> myClass) {
        this.myClass = myClass;

        this.perform();
    }


    public void perform() {
        System.out.println(myClass);
        myClass.doStuff(1);
    }
}

@Component
public class TestClassWithString {

    private MyClass<String, String> myClass;

    @Autowired
    public TestClassWithString(MyClass<String, String> myClass) {
        this.myClass = myClass;

        this.perform();
    }


    public void perform() {
        System.out.println(myClass);
        myClass.doStuff("test");
    }
}

@Component
class MyClass<T, K>{

    public K doStuff(T t){
        System.out.println(t);
        return null;
    }

}