public class A {

private static final Set<Class<? extends A>> INSTANCE_HOLDER = new HashSet<>();

public A() {
    if (INSTANCE_HOLDER.contains(this.getClass()))
        throw new RuntimeException("can't create more than one instance.");

    INSTANCE_HOLDER.add(this.getClass());
}
}