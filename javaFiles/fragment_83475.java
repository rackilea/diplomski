private AdvancedSearchPage(WebDriver driver, Query q) {
    super(driver);
    // Navigates to AdvancedSearchPage url and authenticates if necessary
    this.init(URL);

    if(q.commonName != null) this.setCommonName(q.commonName);
    if(q.contactEmail != null) this.setContactEmail(q.contactEmail);
    if(q.certificateType != null) this.setCertificateType(q.certificateType);
    if(q.status != null) this.setStatus(q.status);

}