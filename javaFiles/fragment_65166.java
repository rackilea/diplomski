public void displayAffectedDistricts(Integer crimeCode) {
    for (String eachDistrict : crimeTable.keySet()) {
        if (crimeTable.get(eachDistrict).contains(crimeCode)) {
           System.out.println("Code "+crimeCode+" found in district "+eachDistrict);
        } 
    }
}