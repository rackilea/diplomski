public class UnixRelativePath {

    public static void main(String[] args) throws Exception {
        FakeFtpServer fakeFtpServer = new FakeFtpServer();
        fakeFtpServer.setServerControlPort(2222);

        fakeFtpServer.addUserAccount(new UserAccount("ftpUser", "ftpPassword",
             "/home/remote"));
        UnixFakeFileSystem fileSystem = new UnixFakeFileSystem();
        fileSystem.add(new FileEntry("/home/remote/a/ftp/some_file.xml",
             "Unix relative path"));

        fakeFtpServer.setFileSystem(fileSystem);
        fakeFtpServer.start();

        CamelContext context = new DefaultCamelContext();
        RouteBuilder rb = new RouteBuilder() {
            @Override
            public void configure() throws Exception {
                // directory with path relative to user home
                from("ftp://ftpUser@localhost:2222/a/ftp?password=ftpPassword"
                        + "&passiveMode=true")
                        .to("file:///tmp/local");
            }
        };

        context.addRoutes(rb);
        context.start();
        TimeUnit.SECONDS.sleep(3);
        context.stop();

        fakeFtpServer.stop();
    }
}