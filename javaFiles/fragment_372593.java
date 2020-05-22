public void drawRectangleConditionally(final Supplier<ShapeFactory> factorySupplier) {
    if (something) {
        final ShapeFactory factory = factorySupplier.get();
        factory.getShape("rectangle").draw();
    }
}
...
drawRectangleConditionally(ShapeFactory::new); 
// the factory will only be created if it's really needed.