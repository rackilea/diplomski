public class DelegatingProperty<B,T> extends ObjectPropertyBase<T>
                                     implements JavaBeanProperty<T> {
    /**
     * Create a property without PropertyChangeEvent based notification.
     */
    public static <O, V> JavaBeanProperty<V> get(O bean, String name,
        Function<? super O, ? extends V> getter,
        BiConsumer<? super O, ? super V> setter) {
        return new DelegatingProperty<>(bean, name, getter, setter, null, null);
    }
    /**
     * Create a property with PropertyChangeEvent based notification.
     */
    public static <O, V> JavaBeanProperty<V> get(O bean, String name,
        Function<? super O, ? extends V> getter, BiConsumer<? super O, ? super V> setter,
        BiConsumer<? super O, ? super PropertyChangeListener> register,
        BiConsumer<? super O, ? super PropertyChangeListener> unregister) {
        return new DelegatingProperty<>(bean, name, getter, setter, register, unregister);
    }
    B bean;
    String name;
    Function<? super B, ? extends T> getter;
    BiConsumer<? super B, ? super T> setter;
    BiConsumer<? super B, ? super PropertyChangeListener> unregister;
    PropertyChangeListener listener;

    private DelegatingProperty(B bean, String name,
        Function<? super B, ? extends T> getter,
        BiConsumer<? super B, ? super T> setter,
        BiConsumer<? super B, ? super PropertyChangeListener> register,
        BiConsumer<? super B, ? super PropertyChangeListener> unregister) {
        this.bean = Objects.requireNonNull(bean);
        this.name = name;
        this.getter = Objects.requireNonNull(getter);
        this.setter = Objects.requireNonNull(setter);
        if(register != null || unregister != null) {
            Objects.requireNonNull(register);
            this.unregister = Objects.requireNonNull(unregister);
            register.accept(bean, listener = event -> fireValueChangedEvent());
        }
    }

    @Override
    public Object getBean() {
        return bean;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public T get() {
        return getter.apply(bean);
    }

    @Override
    public void set(T value) {
        if(isBound()) throw new IllegalStateException("bound property");
        T old = getter.apply(bean);
        setter.accept(bean, value);
        T now = getter.apply(bean);
        if(!Objects.equals(old, now)) fireValueChangedEvent();
    }

    @Override
    protected void invalidated() {
        if(isBound()) {
            setter.accept(bean, super.get());
        }
    }

    @Override
    public void fireValueChangedEvent() {
        super.fireValueChangedEvent();
    }

    @Override
    public void dispose() {
        if(unregister != null && listener != null) {
            unregister.accept(bean, listener);
            listener = null;
        }
    }
}