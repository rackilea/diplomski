Connection con = DriverManager.getConnection(" ... ");
PreparedStatement stmt = con.prepareStatement("Select * from main_contractor");
ResultSet rs = stmt.executeQuery();
Map<String,Company> map = new HashMap<>();
List<Company> mainCompanies = new ArrayList<>();
while (rs.next()) {
    String companyName = rs.getString("company");
    Company company = new Company(companyName);
    map.put(companyName, company);
    mainCompanies.add(company);
    String mainContractor = rs.getString("main_contractor");
    Company contractor = new Company(mainContractor);
    company.getSubcontractors().add(contractor);
    map.put(mainContractor, contractor);
}
PreparedStatement stmt2 = con.prepareStatement("Select * from contract");
rs = stmt2.executeQuery();
while (rs.next()) {
    String contractorName = rs.getString("contractor");
    Company contractor = map.containsKey(contractorName)? map.get(contractorName): new Company(contractorName);
    map.put(contractorName, contractor);
    String subContractorName = rs.getString("subcontractor");
    Company subcontractor = map.containsKey(subContractorName)? map.get(subContractorName): new Company(subContractorName);
    contractor.getSubcontractors().add(subcontractor);
    map.put(subContractorName, subcontractor);
}