if(cd == null)
  {
    cd = new CompanyDocs();//no-arg constructor
    c.setCompanyDocs(cd);
    cd.setCompany(c);
    LOG.info("CompanyDocs object created new :- " + cd);
    companyDao.storeCompanyDocs(cd);
    LOG.info("CompanyDocs object stored :- " + cd.getDocsid());     
  }