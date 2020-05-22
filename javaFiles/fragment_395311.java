public CodeToBrands(String code, String brand) {
    this.code = code;
    this.brands.add(brand);
}

public CodeToBrands merge(CodeToBrands another) {
    this.brands.addAll(another.getBrands());
    return this;
}