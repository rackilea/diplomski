String to = "product-card__price\">";
String remainingText = webPage;
ArrayList<Integer> integers = new ArrayList<>();
while (remainingText.indexOf(to) >= 0) {
    String tokenString = remainingText.substring(remainingText.indexOf(to) + to.length());
    String priceString = tokenString.substring(0, tokenString.indexOf("<"));
    int price = Integer.parseInt(priceString.replaceAll("\\D+",""));
    integers.add(price);
    remainingText = tokenString;
}