StringBuilder products = new StringBuilder();
for (int i = 0; i < list.size(); i++) {
    products.append(list.get(i));
    if (i + 2 < list.size()) products.append(", ");
    else if (i + 2 == list.size()) products.append(" and "); // Localize this?
}
getValue(bundle, "my.message", products);