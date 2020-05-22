...
@Override
    //The order matters, your certificate should be the first one in the chain, its issuer the second, its issuer's issuer the third and so on.
public X509Certificate[] getCertificateChain(String arg0) {
            X509Certificate[] result = new X509Certificate[2];
            //The certificate chain contains only one entry in my case
            result[0] = (X509Certificate) keystore.getCertificateChain(keystore.aliases().nextElement())[0];
            //Implement getMyCertificateIssuer() according to your needs. In my case, I read it from a JKS keystore from my database
            result[1] = getMyCertificateIssuer();
            return result;
}
...