public void java8Method(final Collection<Item> items) {
    getLayerHolders().forEach(layerHolder -> {
        Optional.of(layerHolder)
                .map(LayerHolder::getLayer)
                .filter(MyLayer.class::isInstance)
                .map(l -> ((MyLayer)l).getItem())
                .ifPresent(current-> items.stream()
                    .filter(item ->
                        Objects.equals(item.getSomeKey(), current.getSomeKey())
                     && Objects.equals(item.getSomeOtherKey(), current.getSomeOtherKey()))
                    .forEach(ignored ->
                             getObjectBasedOnItem(current).doSomething(layerHolder))
            );
    });
}