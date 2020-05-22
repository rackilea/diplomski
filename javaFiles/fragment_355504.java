String s = "";
    while (rs.next()) {
        s += rs.getString("column_name");
    }

    if (exportTo.equals("text")) {
        response.setContentType("text/plain");
        response.setHeader("Content-Disposition", "attachment;filename=downloadname.txt");

        try {
            InputStream input = new ByteArrayInputStream(s.getBytes("UTF8"));

            int read = 0;
            byte[] bytes = new byte[BYTES_DOWNLOAD];
            OutputStream os = response.getOutputStream();

            //data form resultset

            while ((read = input.read(bytes)) != -1) {
                os.write(bytes, 0, read);
            }
            os.flush();
            os.close();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }