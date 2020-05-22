System.out
     .println("Signature algorithm: " + serverCert.getSigAlgName());
Signature sig = Signature.getInstance(serverCert.getSigAlgName());
sig.initVerify(caCert.getPublicKey());
sig.update(serverCert.getTBSCertificate());
System.out
    .println("Verified? " + sig.verify(serverCert.getSignature()));