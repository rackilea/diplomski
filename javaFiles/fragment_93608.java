public Map<String, Node> nodes = new HashMap<>();

    SimpleObjectProperty<Callback<PropertySheet.Item, PropertyEditor<?>>> propertyEditorFactory = 
new SimpleObjectProperty<>(this, "propertyEditor", new DefaultPropertyEditorFactory());

    propertySheet.setPropertyEditorFactory((PropertySheet.Item param) -> {
       PropertyEditor node = propertyEditorFactory.get().call(param);
       nodes.put(uniquePropertyName, node.getEditor());
       return node;
    });