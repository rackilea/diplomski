for (DataSnapshot child : children) {
    List<String> products = new ArrayList<>();
    Product value = child.getValue(Product.class);
    products.add(value.getDescription() + " / " + child.getValue());
}

ArrayAdapter<String> productAdapter = new ArrayAdapter<String>(
    getApplicationContext(),
    android.R.layout.simple_list_item_1,
    products
);
listViewProducts.setAdapter(productAdapter);