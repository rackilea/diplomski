response.setContentType("text/html");
    String gurufile = "test.txt";
    String gurupath = "D:\\guru99\\";
    response.setContentType("APPLICATION/OCTET-STREAM");
    response.setHeader("Content-Disposition", "attachment; filename=\"" + gurufile + "\"");
    try (FileInputStream fileInputStream = new FileInputStream(gurupath + gurufile);
        PrintWriter out = response.getWriter();) {
        int i;
        while ((i = fileInputStream.read()) != -1) {
        out.write(i);
        }
    }