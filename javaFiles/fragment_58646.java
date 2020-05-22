public class DependentCallable implements Callable {

private final String name;
private final Future pre;

public DependentCallable(String name, Future pre) {
    this.name = name;
    this.pre = pre;
}

@Override
public Object call() throws Exception {
    if (pre != null) {
        pre.get();
        //pre.get(10, TimeUnit.SECONDS);
    }
    System.out.println(name);
    return name;
}