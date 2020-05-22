Client client = ClientBuilder.newClient();
    WebTarget myResource = client.target("http://localhost:8080/web/rest/report");
    Report m = new Report();
    m.setId((long) 12);
    m.setReportContent("asdf");
    Entity<Report> report = Entity.json(m);
    Response r = myResource.request(MediaType.APPLICATION_JSON).post(report);
    System.out.println(r.getHeaderString("Location"));