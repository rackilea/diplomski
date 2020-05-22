List<Attachment> atts = new LinkedList<Attachment>();
        ContentDisposition cd = new ContentDisposition("form-data; name=\"file\";filename=\"test.txt\"");
        atts.add(new Attachment("file", new ByteArrayInputStream("testContent".getBytes()),cd));
        ContentDisposition cd1 = new ContentDisposition("form-data; name=\"param1\";");
        atts.add(new Attachment("param1",new ByteArrayInputStream("paramValue".getBytes()),cd1));
        ContentDisposition cd2 = new ContentDisposition("form-data; name=\"param2\";");
        atts.add(new Attachment("param2",new ByteArrayInputStream("value".getBytes()),cd1));
        MultipartBody body = new MultipartBody(atts);
        Response response= client.post(body);