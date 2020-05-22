class C<T>{
    private final Class<T> clazz;

    C(Class<T> clazz) {
        this.clazz = clazz;
    }

    public Class<T> getClazz(){
        return clazz;
    }
}

class D{
    public <T> T getInstance(C<T> t) throws IllegalAccessException, InstantiationException {
        return t.getClazz().newInstance();
    }
}


public static void main() throws Exception {
    C<String> c = new C<>(String.class);
    D d = new D();
    String s = d.getInstance(c);
    System.out.println("String = " + s);
}