rest("/api")
        .get("/booksByAuthor/{author}")
        .route()
        .pollEnrich("file:/?fileName=conf.xml&noop=true", (original, xml) -> {
                original.getIn().setBody(xml.getIn().getBody());
                return original;})
        .to("xslt:/transformers/booksByAuthor.xsl");