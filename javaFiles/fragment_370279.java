else if (xs instanceof X509Data) {
     for (Object data : ((X509Data) xs).getContent()) {
          if (data instanceof X509Certificate) {
              pk = ((X509Certificate) data).getPublicKey();
          }
     }
}