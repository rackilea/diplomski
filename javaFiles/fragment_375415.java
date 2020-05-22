String[] validIDs = TimeZone.getAvailableIDs();
for (String str : validIDs) {
      if (str != null && str.equals("yourString")) {
        System.out.println("Valid ID");
      }
}