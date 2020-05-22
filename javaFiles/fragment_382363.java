public static void main(final String[] args) throws Exception {
         System.setProperty("java.security.krb5.conf", "krb5.conf");
         System.setProperty("sun.security.krb5.debug", "true");
         System.setProperty("java.security.auth.login.config", "login.conf");

         SpnegoHttpURLConnection spnego = null;

         try {
             spnego = new SpnegoHttpURLConnection("spnego-client", "username", "password");
             spnego.connect(new URL("http://medusa:8080/index.jsp"));

             System.out.println(spnego.getResponseCode());

         } finally {
             if (null != spnego) {
                 spnego.disconnect();
             }
         }
     }