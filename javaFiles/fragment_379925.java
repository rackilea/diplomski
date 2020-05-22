public interface ObjectMethods
    {
        public static class CONSTANTS
        {
               static final Method getModulus ;
               static
               {
                     try
                     {
                           getModulus = RSAPublicKey.class.getMethod("setModulus", byte[].class, short.class, short.class);
                     }
                     catch ( Exception cause ) { //handle it }
              }
         }

    }