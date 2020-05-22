try {
     // stuff
} catch (SuperException ex) {
     if (ex instanceof Exception1 || ex instanceof Exception2) {
         // handle exception
     } else {
         throw ex;
     }
}