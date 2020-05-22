public static <V> JavaBeanProperty<V> property(Entity theBean, String name,
    Function<? super Entity, ? extends V> getter,
    BiConsumer<? super Entity, ? super V> setter) {
    return DelegatingProperty.get(theBean, name, getter, setter,
        Entity::addPropertyChangeListener, Entity::removePropertyChangeListener);
}