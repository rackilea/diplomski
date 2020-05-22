String cipherSuite = (String) req.getAttribute("javax.servlet.request.cipher_suite");

if (cipherSuite != null) {
    X509Certificate certChain[] = (X509Certificate[]) req.getAttribute("javax.servlet.request.X509Certificate");
    if (certChain != null) {
        for (int i = 0; i < certChain.length; i++) {
            System.out.println ("Client Certificate [" + i + "] = "
                    + certChain[i].toString());
        }
    }
}