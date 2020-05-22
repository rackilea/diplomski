byte[] buf = IOUtils.toByteArray(in);

        String prefix = "{\"url\":\"data:image/jpeg;base64,";
        String postfix = "\"}";
        String fileJson = prefix + Base64.encodeBytes(buf).replaceAll("\n", "") + postfix; 
        PrintWriter out = resp.getWriter();
        out.write(fileJson);
        out.flush();
        in.close();
        out.close();