public String printStrings() {
     String strings = "";
        for (int i = 0; i < values.length; i++) {
         strings = strings + " "+ values[i].toString();
       }
      return strings;
    }