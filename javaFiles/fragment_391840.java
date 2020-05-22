class PickField<T extends Pick<T>> extends Field<T> {

    public PickField(Class<T> c) {
        super(c);
    }
}