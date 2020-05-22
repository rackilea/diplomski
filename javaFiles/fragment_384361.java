List data =em.createQuery("SELECT u.firstname, u.lastname, u.workEmail FROM Employee u", Report.class)
                    .getResultList();
 List<Report> results = new ArrayList<Report>();

 for (Object object : data) {
    Map row = (Map) object;
    Report report = new Report();
    report.setFirstName(row.get("0"));
    report.setLastName(row.get("1"));
    report.setWorkEmail (row.get("2"));
    results.add(report); 
 }