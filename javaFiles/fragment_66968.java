String filePath = request.getParameter("action");
        System.out.println(filePath);
        // URL url = new
        // URL("http://localhost:8080/Works/images/abt.jpg");
        response.setContentType("image/jpeg");
        response.setHeader("Content-Disposition", "attachment; filename=icon" + ".jpg");
        URL url = new URL(filePath);
        URLConnection connection = url.openConnection();
        InputStream stream = connection.getInputStream();

        BufferedOutputStream outs = new BufferedOutputStream(response.getOutputStream());
        int len;
        byte[] buf = new byte[1024];
        while ((len = stream.read(buf)) > 0) {
            outs.write(buf, 0, len);
        }
        outs.close();
    }