Signature signature = Signature.getInstance("SHA256withRSA",p);
                        System.out.println(" signature.getProvider():"+ signature.getProvider());
                        signature.initSign(privateKey, new SecureRandom());
                        signature.update(byteData);
                        byte[] signatureBytes = signature.sign();




//                      X509Certificate cert1 =signatureBytes. 
                        System.out.println("signatureBytes-------------"+ signatureBytes.toString());
                        // ----------------------signature----------end------------------

                        // ------------------------verification---------------
                        Signature signature1 = Signature.getInstance("SHA256withRSA");
                        System.out.println(" signature1.getProvider():"+ signature1.getProvider());
                        signature1.initVerify(publicKey);
                        signature1.update(byteData);

                        boolean verifies = signature1.verify(signatureBytes);
                        System.out.println("signature verifies: " + verifies);