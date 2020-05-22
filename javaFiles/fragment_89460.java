public class Test {
    public static void main(String[] args) throws IllegalAccessException,
            InstantiationException {
        Generic<Bar> x = new Generic<>(Bar.class);
        Bar y = x.buildOne();
    }
}

public class Generic<T> {
    private Class<T> clazz;

    public Generic(Class<T> clazz) {
        this.clazz = clazz;
    }

    public T buildOne() throws InstantiationException, IllegalAccessException {
        return clazz.newInstance();
    }
}

public class Bar {
    public Bar() {
        System.out.println("Constructing");
    }
}