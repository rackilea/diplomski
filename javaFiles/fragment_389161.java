List<CompanyBasicInfo> find(String input) {
  Long companyId = null;
  try {
    companyId = Long.valueOf(input);
  } catch(Exception ignored){}

  return repository.findByCompanyIDOrCompanyName(companyId, input);
}