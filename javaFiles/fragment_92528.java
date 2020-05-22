try {
   // covered by "outer" finally
}
catch (Exception1 ex) {
   // covered by "outer" finally

   try {
     // Covered by both "inner" and "outer" finallys
   }
   catch (Exception2 ex) {
     // Covered by both "inner" and "outer" finallys
   }
   catch (Exception3 ex) {
     // Covered by both "inner" and "outer" finallys
   }
   finally { // "inner" finally
   }
}
catch (Exception4 ex) {
   // covered by "outer" finally
}
finally { // "outer" finally
}