//return an application file instead of html page
    response.setContentType("text/xml");//"application/octet-stream");
    response.setHeader("Content-Disposition", "attachment;filename="
        + xmlFilename);

    OutputStream out = null;
    out = response.getOutputStream();