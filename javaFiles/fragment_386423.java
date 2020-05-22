class Element<T> {
    public Class<T> elementType;

    <U extends Processor<? extends T>> void setProcessor(U processor) {}

    @SuppressWarnings("unchecked")
    public <E> Element<E> getTyped(Class<E> type) {
        if (type == elementType) return (Element<E>) this;
        else return null;
    }
}

Element<?> e = new Element<String>();
Element<String> es = e.getTyped(String.class);
if (es != null) es.setProcessor(new StringProcessor());