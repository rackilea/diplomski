try {
   if (string1 != null && string1.trim().equals("")) {
      number1 = Integer.parseInt(string1.trim(), 2);
   }
   // check other strings...
} catch (Exception e) {
    // do something if exception occur
}