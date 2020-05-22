from("direct:wiretap")
    .routeId("WireTap")
    .process(e -> {
        String fileName = (String) e.getProperty("filename");
        if (new File(fileName).exists()) {
            //Compute alternative name
            e.getIn().setHeader("CamelFileName", 
                                fileName + UUID.randomUUID().toString());
        } else {
            e.getIn().setHeader("CamelFileName", fileName);
        }
    })
    .to("file://log-directory-name");