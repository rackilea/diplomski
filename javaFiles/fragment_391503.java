Map<String, Long> countMap = new HashMap<String, Long>();
    Collection<?> itemIDS = container.getItemIds();
    for (Object itemID : itemIDS) {
        Property statusProperty = container.getContainerProperty(itemID, "status");
        Property numProperty = container.getContainerProperty(itemID, "num");
        countMap.put((String) statusProperty.getValue(), (Long) numProperty.getValue());
    }