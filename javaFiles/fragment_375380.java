// Trusted certificates sources, root and intermediates (#5 )
    CertificateSource trustedCertSource = null;
    CertificateSource adjunctCertSource = null;


    // The certificate to be validated
    CertificateToken token = DSSUtils.loadCertificate(new File("src/main/resources/keystore/ec.europa.eu.1.cer"));

    // Creates a CertificateVerifier using Online sources. It checks the revocation status with the CRL lists URLs or OCSP server extracted from the certificate #3
    CertificateVerifier cv = new CommonCertificateVerifier();
    cv.setAdjunctCertSource(adjunctCertSource);     
    cv.setTrustedCertSource(trustedCertSource);

    // Creates an instance of the CertificateValidator with the certificate
    CertificateValidator validator = CertificateValidator.fromCertificate(token);
    validator.setCertificateVerifier(cv);

    // We execute the validation (#1, #2, #3, #5)
    CertificateReports certificateReports = validator.validate();

    //The final result. You have also a detailedReport and DiagnosticData
    SimpleCertificateReport simpleReport = certificateReports.getSimpleReport();