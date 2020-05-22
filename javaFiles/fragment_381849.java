File f = new File("d:\\....");
    int length = 0;
    ServletOutputStream op = response.getOutputStream();
    ServletContext context = getServletConfig().getServletContext();
    String mimetype = context.getMimeType("d:\\Zene\\WakaWaka.mp3");

    //
    // Set the response and go!
    //
    //
    response.setContentType((mimetype != null) ? mimetype : "application/octet-stream");
    response.setContentLength((int) f.length());
    response.setHeader("Content-Disposition", "attachment; filename=\"" + "seven-eurotura.cd1.avi" + "\"");

    //
    // Stream to the requester.
    //
    byte[] bbuf = new byte[100];
    DataInputStream in = new DataInputStream(new FileInputStream(f));

    while ((in != null) && ((length = in.read(bbuf)) != -1)) {
        op.write(bbuf, 0, length);
    }