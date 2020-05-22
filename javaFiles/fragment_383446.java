String number = "";
for (char c : txtProductSalePrice.toCharArray()) {
    if (c == "۱") {
        number.concat("1");
        continue;
    }
    if (c == "۲") {
        number.concat("2");
        continue;
    }
    ....
}
return new BigDecimal(number).doubleValue();