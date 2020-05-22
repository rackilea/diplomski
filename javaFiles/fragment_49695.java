public static final Certificate[] readCertificatesFromPKCS7(byte[] binaryPKCS7Store) throws Exception
{
    try (ByteArrayInputStream bais = new ByteArrayInputStream(binaryPKCS7Store);)
    {
        CertificateFactory cf = CertificateFactory.getInstance("X.509");
        Collection<?> c = cf.generateCertificates(bais);

        List<Certificate> certList = new ArrayList<Certificate>();

        if (c.isEmpty())
        {
            // If there are now certificates found, the p7b file is probably not in binary format.
            // It may be in base64 format.
            // The generateCertificates method only understands raw data.
        }
        else
        {

            Iterator<?> i = c.iterator();

            while (i.hasNext())
            {
                certList.add((Certificate) i.next());
            }
        }

        java.security.cert.Certificate[] certArr = new java.security.cert.Certificate[certList.size()];

        return certList.toArray(certArr);
    }
}