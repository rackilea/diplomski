public <T extends Item> void printItems(List<Item> items, Class<T> clazz) {
    for(Item item : items) {
        // Check if item is of the same type or a subtype of the specified class.
        if(clazz.isAssignableFrom(item.getClass())) {
            // print it
        }
    }
}