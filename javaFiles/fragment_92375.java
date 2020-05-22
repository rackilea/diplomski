public AutoComplete() {
    setConverter(new StringConverter<T>(){
        @Override
        public String toString(T item) {
            return item == null ? null : display(item);
        }
        @Override
        public T fromString(String string) {
            return getFromString(string);
        }
    });
}

protected abstract T getFromString(String input);

protected abstract String display(T item);