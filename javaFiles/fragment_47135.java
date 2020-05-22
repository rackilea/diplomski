StringBuilder postDataBuilder = new StringBuilder();
        byte[] postData = postDataBuilder.toString().getBytes("UTF-8");

        OutputStream out = conn.getOutputStream();
        out.write(postData);
        out.close();