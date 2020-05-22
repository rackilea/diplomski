String[] productAndQuantity = productSold.split(",");
if (productAndQuantity.length == 2) {
    productCode = Integer.parseInt(productAndQuantity[0]);
    quantitySold = Integer.parseInt(productAndQuantity[1]);
} else {
    // TODO handle missing values
}