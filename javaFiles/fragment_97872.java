class Product {
    void addCategory(CategorySnapshot category) {
        categories.add(category);
        eventPublisher.publish(new ProductCategoryAdded(getSnapshot(), category));
    }
}