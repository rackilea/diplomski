// create array
X509Certificate[] certificatesArray = new X509Certificate[3];

// add certificates in allCerts (the 2 that were in certStore)
int i = 0;
for (Certificate c : allCerts) {
    certificatesArray[i] = (X509Certificate) c;
    i++;
}

// add the new certificate (newCert being a X509Certificate)
certificatesArray[2] = newCert;