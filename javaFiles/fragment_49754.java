Collection<? extends Certificate> allCerts = certStore.getCertificates(new X509CertSelector() {
    @Override
    public boolean match(Certificate cert) {
        // match all certificates (so it'll return all of them)
        return true;
    }
});