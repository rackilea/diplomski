String code = scan.next();
boolean match = false;
for (Product product : list) {
    if (code.equalsIgnoreCase(product.getCode())) {
        match = true;
        break;
    }
}
// now only if match is false do you have an invalid product code.