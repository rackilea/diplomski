boolean containsEqualsIgnoreCase(Collection<String> c, String s) {
   for (String str : c) {
      if (s.equalsIgnoreCase(str)) {
          return true;
      }
   }
   return false;
}