public void displayAffectedDistricts(Integer crimeCode) {
    for (Map.Entry<String, ArrayList<Integer>> entry : crimeTable.entrySet()) {
        if (entry.getValue().contains(crimeCode)) {
           System.out.println("Code "+crimeCode+" found in district "+entry.getKey());
        } 
    }
}