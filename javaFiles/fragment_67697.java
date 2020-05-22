public class SwitchDemo {

public static SwitchInputType<?> switchInput(String typeName) {
    if (typeName.equals("java.lang.String")) {
        return new SwitchInputType<String>(new String("A"));
    } else if (typeName.equals("int")) {
        return new SwitchInputType<Integer>(new Integer(312));
    }
    return null;
}

public static class SwitchInputType<T> {
    private T type;

    public SwitchInputType(T type) {
        super();
        this.type = type;
    }

    public T getType() {
        return type;
    }

    public void setType(T type) {
        this.type = type;
    }
}

public static void main(String[] args) {
    SwitchInputType<?> sit1 = SwitchDemo.switchInput("java.lang.String");
    System.out.println(sit1.getType());
    SwitchInputType<?> sit2 = SwitchDemo.switchInput("int");
    System.out.println(sit2.getType());
}