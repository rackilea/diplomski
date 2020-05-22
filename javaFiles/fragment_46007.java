public void java8Method(final Collection<Item> items) {
    getLayerHolders().forEach(layerHolder ->
        Optional.of(layerHolder)
                .map(LayerHolder::getLayer)
                .filter(MyLayer.class::isInstance)
                .map(l -> ((MyLayer)l).getItem())
                .filter(current-> items.stream()
                    .anyMatch(item ->
                        Objects.equals(item.getSomeKey(), current.getSomeKey())
                     && Objects.equals(item.getSomeOtherKey(), current.getSomeOtherKey())))
                .ifPresent(current ->
                           getObjectBasedOnItem(current).doSomething(layerHolder))
    );
}