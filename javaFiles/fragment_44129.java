public static void assertEquals(String msg, Object obj1, Object obj2) {
     if (obj1 == null && obj2 == null) {
       return;
     }

     if (obj1 != null && obj1.equals(obj2)) {
       return;
     }

     fail(msg + " expected=" + obj1 + " actual=" + obj2);
 }