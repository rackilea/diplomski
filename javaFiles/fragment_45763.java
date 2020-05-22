//Create a temp keystore with the server certificate  

KeyStore ksTemp = KeyStore.getInstance("JKS");    
ksTemp.load(null, null);//Initialize it  
ksTemp.setCertificateEntry("Alias", cert);   
ByteArrayOutputStream bOut = new ByteArrayOutputStream();  
// save the temp keystore
ks.store(bOut, password);  

//Now create the keystore to be used by jsse   
Keystore store = KeyStore.getInstance("JKS");   
store.load(new ByteArrayInputStream(bOut.toByteArray()), password);