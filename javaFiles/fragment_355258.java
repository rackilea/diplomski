response.setContentType("application/xml");
    response.setHeader("Pragma", "no-cache");
    response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate, post-check=0, pre-check=0");
    response.setHeader("Expires", "0");
    response.setHeader("Content-Disposition", "attachment;filename=\"Classification.xml\"");

    JAXBContext context = JAXBContext.newInstance(Classification.class);
    Marshaller m = context.createMarshaller();
    m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

    m.marshal(xmlToDownload, response.getOutputStream());