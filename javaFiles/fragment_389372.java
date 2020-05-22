BigDecimal firstDecimal = BigDecimal.valueOf(0.101).setScale(2, RoundingMode.CEILING);
BigDecimal secondDecimal = BigDecimal.valueOf(0.10999).setScale(2, RoundingMode.CEILING);
BigDecimal thirdDecimal = BigDecimal.valueOf(0.110000).setScale(2, RoundingMode.CEILING);
BigDecimal fourthDecimal = BigDecimal.valueOf(0.1101).setScale(2, RoundingMode.CEILING);

System.out.println(firstDecimal); // 0.11
System.out.println(secondDecimal); // 0.11
System.out.println(thirdDecimal); // 0.11
System.out.println(fourthDecimal); // 0.12