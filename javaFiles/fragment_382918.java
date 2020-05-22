private String returnMostRecent(String[] fileNames) {
   String file = null;
   double version = -1;
   for(String name : listNames)
   {
      // skip files that don't match
      if (!name.matches("ALFP[0-9]*F.zip"))
          continue;
      // get digits only
      String digits = name.replaceAll("\\D+","");
      // format digits to <year>.<version>
      String vstr = digits.substring(digits.length-2,digits.length()) + ".";
      if (digits.length() < 4)
         vstr += "0";
      vstr = digits.substring(0, digits.length()-2);
      double v = Double.parseDouble(vstr);
      if (v > version)
      {
          version = v;
          file = name;
      }
   }

   return file;
}