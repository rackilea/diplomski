@Override
public int hashCode() {
    return id.hashCode();
}

@Override
public boolean equals(Object o) {
    Product product = (Product) o;
    return id.equals(product.id);
}