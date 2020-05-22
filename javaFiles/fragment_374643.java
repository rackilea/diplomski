MultipartEntityBuilder meb = MultipartEntityBuilder.create();
    meb.setMode(HttpMultipartMode.BROWSER_COMPATIBLE);
    meb.addPart("to", new StringBody("The recipient", ContentType.TEXT_PLAIN));
    meb.addPart("from", new StringBody("The sender", ContentType.TEXT_PLAIN));
    FileBody fb = new FileBody(new File("path/to/your/file"), ContentType.create("image/jpeg"));
    meb.addPart("file", fb);
    meb.addPart("footer", new StringBody("The footer", ContentType.TEXT_PLAIN));
    httppost.setEntity(meb.build());