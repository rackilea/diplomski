Elements eles = doc.select("table tr");

  for (int i = 0; i < eles.size(); i++) {
     Elements rowEles = eles.get(i).select("form");

     Elements goldEles = rowEles.select("[name=gold]");
     String goldValue = goldEles.attr("value");

     Elements priceEles = rowEles.select("[name=price]");
     String priceValue = priceEles.attr("value");

     System.out.printf("%-7s: %-5s%n", goldValue, priceValue);
  }