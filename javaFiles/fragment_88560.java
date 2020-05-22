public class Main {    
    public static void main(String[] args) {
        getHasValue().addValueChangeListener(evt -> {});
    }

    public static HasValue<?, ?> getHasValue() {
        return null;
    }    
}

interface HasValue<E extends HasValue.ValueChangeEvent<V>,V> {    
    public static interface ValueChangeEvent<V> {}    
    public static interface ValueChangeListener<E extends HasValue.ValueChangeEvent<?>> {
        void valueChanged(E event);
    }    
    void addValueChangeListener(HasValue.ValueChangeListener<? super E> listener);
}