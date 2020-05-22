Map<String, String> map = Map.of("sellerId", "abc",
        "shipmentId", "123");
String yourTemplate = "sellers(seller: $sellerId, shipment: $shipmentId)";

Pattern p = Pattern.compile("\\$(\\w+)");
Matcher m = p.matcher(yourTemplate);

String replaced = m.replaceAll(match -> {
    if(map.containsKey(match.group(1))){
        return Matcher.quoteReplacement(map.get(match.group(1)));
    }else{
        return Matcher.quoteReplacement(match.group());
    }
});
System.out.println(replaced);