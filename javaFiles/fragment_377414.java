for (String host : hosts) {
   try {
      Connection c = getConnection(host);
      if (c != null) { 
         return c;
      }
      // log here (not sure I'd return null at all, mind)
   }
   catch (Exception e) {
      // log here...
   }
}
// fail completely