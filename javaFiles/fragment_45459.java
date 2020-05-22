Model model = new Model();
    ReportPlugin reportPlugin = new ReportPlugin();
    reportPlugin.setGroupId("org.codehaus.mojo");
    reportPlugin.setArtifactId("cobertura-maven-plugin");
    Reporting reporting = new Reporting();
    reporting.addPlugin(reportPlugin);
    model.setReporting(reporting);

    StringWriter writer = new StringWriter();
    MavenXpp3Writer xpp = new MavenXpp3Writer();
    try {
        xpp.write(writer, model);
        System.out.println(writer.toString());
    } catch (IOException e) {
        e.printStackTrace();
    }