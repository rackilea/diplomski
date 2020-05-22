@Reference(
   name = "componentFactories",
   referenceInterface = ComponentFactory.class,
   cardinality = ReferenceCardinality.OPTIONAL_MULTIPLE,
   policy = ReferencePolicy.DYNAMIC
)
protected List<ComponentFactory> componentFactories = new ArrayList<ComponentFactory>();