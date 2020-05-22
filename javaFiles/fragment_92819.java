public void deleteItem(Long id) {
    final Item item = itemRepository.findById(id);
    // you can handle here when not found, which is a good thing to do
    item.getCategories().clear();
    itemRepository.deleteItem(item);
}