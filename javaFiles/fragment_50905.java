package com.foo;

import java.io.IOException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;


public class KeyStoreService {
  public KeyStoreService(){

  }

  public void load() throws KeyStoreException, NoSuchAlgorithmException, CertificateException, IOException{
    System.out.println("start");
    KeyStore ks = KeyStore.getInstance("");
    ks.load(null, null);
    System.out.println("end");
 }


}