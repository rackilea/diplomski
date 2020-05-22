public void iterate(SimpleEntity entity, Consumer<SimpleEntity> consumer) {
    consumer.accept(entity);
    for (SimpleEntity child : entity.getSimpleEntityChildren()) {
        iterate(child,consumer);
    }
}