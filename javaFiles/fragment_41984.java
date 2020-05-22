HttpAutomationClient client = new HttpAutomationClient("http://localhost:8080/nuxeo/site/automation");
Session session = client.getSession("Administrator", "Administrator");
File dummyFile = new File("/tmp/dummy");
session.newRequest("Blob.AttachOnDocument")
    .set("document", "/path/to/my/doc")
    .set("xpath", "files:files")
    .setInput(new Blobs(Arrays.asList(
            new FileBlob(dummyFile),
            new FileBlob(dummyFile),
            new FileBlob(dummyFile)
    ))).execute();