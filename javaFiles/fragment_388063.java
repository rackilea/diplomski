List<Mapping> list = new ArrayList<>();
list.add(new Mapping(MyObject::getF1, s -> s.replaceAll("x", "a"), bar::setF1));
list.add(new Mapping(MyObject::getF2, s -> s.replaceAll("x", "a"), bar::setF2));
list.add(new Mapping(MyObject::getF10, s -> s.replaceAll("x", "a"), bar::setF10));

list.forEach(mapping -> {
    Optional.of(bar)
            .map(mapping.getGtterFunction)
            .map(mapping.getTransformationFunction)
            .ifPresent(mapping.getSetterFunction);
});