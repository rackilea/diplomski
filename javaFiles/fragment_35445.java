binder.setFieldFactory(new DefaultFieldGroupFieldFactory() {

    @Override
    public <T extends Field> T createField(Class<?> type, Class<T> fieldType) {

        if (type.isAssignableFrom(String.class) && fieldType.isAssignableFrom(ComboBox.class)) {
            return (T) new ComboBox();
        }

        return super.createField(type, fieldType);
    }

});