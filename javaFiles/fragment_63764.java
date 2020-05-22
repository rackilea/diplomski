SimpleObjectProperty<Callback<PropertySheet.Item, PropertyEditor<?>>> propertyEditorFactory = new SimpleObjectProperty<>(this, "propertyEditor", new DefaultPropertyEditorFactory());
    projectSheet.setPropertyEditorFactory(getItemPropertyEditorCallback(propertyEditorFactory));



private Callback<PropertySheet.Item, PropertyEditor<?>> getItemPropertyEditorCallback(SimpleObjectProperty<Callback<PropertySheet.Item, PropertyEditor<?>>> propertyEditorFactory) {
    return param -> {
        PropertyEditor<?> editor = propertyEditorFactory.get().call(param);

        //Add listeners to editor
        editor.getEditor().focusedProperty().addListener((observable, oldValue, newValue) -> System.out.println(newValue));

        return editor;
    };
}