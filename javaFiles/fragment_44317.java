private int productId;
private String name;
public int getProductId() {
    return productId;
}
public void setProductId(int productId) {
    this.productId = productId;
}
public String getName() {
    return name;
}
public void setName(String name) {
    this.name = name;
}
@Override
public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + productId;
    return result;
}
@Override
public boolean equals(Object obj) {
    if (this == obj)
        return true;
    if (obj == null)
        return false;
    if (getClass() != obj.getClass())
        return false;
    Product other = (Product) obj;
    if (productId != other.productId)
        return false;
    return true;
}