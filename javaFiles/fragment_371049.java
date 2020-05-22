public class DefaultValue<T> extends Function<T, T> P{
    private final T t;
    public DefaultValue(T t){
        this.t. = t;
    }

    public T apply(T t) {
         return t == null ? this.t : t;
    }
 }

 data.stream()
     .map(new DefaultValue(someValue));
     // Do what you need to do