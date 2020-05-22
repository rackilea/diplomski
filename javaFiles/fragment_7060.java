private static final Map<String, String> conversionMap = Stream.of(
         new SimpleEntry<>("a", "0"),
         new SimpleEntry<>("b", "1"),
         new SimpleEntry<>("c", "2"),
         new SimpleEntry<>("d", "3" ),
         new SimpleEntry<>("e", "4"),
         new SimpleEntry<>("f", "5"),
         new SimpleEntry<>("g", "6"),
         new SimpleEntry<>("h", "7" ),
         new SimpleEntry<>("i", "8"),
         new SimpleEntry<>("j", "9"),
         new SimpleEntry<>(".", "."))
         .collect(Collectors.toMap((se) -> se.getKey(), (se) -> se.getValue()));

   public static double decrypt(String encryptedNumber) {
      StringBuilder builder = new StringBuilder();
      String[] encNumElements = encryptedNumber.toLowerCase().split("");
      for (String element : encNumElements) {         
            builder.append(conversionMap.get(element));
      }

      double d = Double.parseDouble(builder.toString());
      return d;
   }