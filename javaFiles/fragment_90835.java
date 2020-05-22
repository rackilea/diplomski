private void parseString() {
      String data = "1300-1320:1,1325-1345:5,1350-1410:9,1415-1435:1";

      String[] commaStrings = data.split(",");
      for (String commaString : commaStrings) {
          String[] hours = commaString.split(":");
          String[] times = hours[0].split("-");

          String t1 = padded(times[0], 2, ":");
          String t2 = padded(times[1], 2, ":");
          String hour = t1 + " to " + t2;
          System.out.println("Hour: " + hour + " available: " + hours[1]);
      }
    }

    private String padded(String original, int charLimit, String separator) {
      StringBuilder formatted = new StringBuilder();

      for (int i = 0; i < original.length(); i++) {
         if (i % charLimit == 0 && i > 0) {
            formatted.append(separator);
         }
         formatted.append(original.substring(i, i + 1));
      }

      return formatted.toString();
   }