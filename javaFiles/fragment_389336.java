EncryptedData encryptedDataElement =
        xmlCipher.getEncryptedData();
KeyInfo keyInfo = new KeyInfo(document);
X509Data x509data = new org.apache.xml.security.keys.content.X509Data(document);
x509data.addCertificate(cert);
keyInfo.add(x509data);
keyInfo.add(encKey);

encryptedDataElement.setKeyInfo(keyInfo);

// do the actual encryption
xmlCipher.doFinal(document,
        rootElement, true);