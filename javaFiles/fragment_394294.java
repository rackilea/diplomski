class MyClass {

    public List<LightItem> someMethod() {
        return items.stream()
            .map(MyClass::buildLightItem)
            .collect(Collectors.toList());
    }

    private static LightItem buildLightItem(Item item) {
        return new LightItem(item.getId(), item.getName());
    }

}