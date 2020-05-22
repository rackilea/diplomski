public class WindowsRelativePath {

    public static void main(String[] args) throws Exception {
        FakeFtpServer fakeFtpServer = new FakeFtpServer();
        fakeFtpServer.setServerControlPort(2222);

        fakeFtpServer.addUserAccount(new UserAccount("ftpUser", "ftpPassword", "C:\\home"));
        WindowsFakeFileSystem fileSystem = new WindowsFakeFileSystem();
        fileSystem.add(new FileEntry("C:\\home\\a\\ftp\\some_file.xml",
            "Windows relative path"));

        fakeFtpServer.setFileSystem(fileSystem);
        fakeFtpServer.start();

        CamelContext context = new DefaultCamelContext();
        RouteBuilder rb = new RouteBuilder() {
            @Override
            public void configure() throws Exception {
                // directory with path relative to user home
                from("ftp://ftpUser@localhost:2222/a/ftp?password=ftpPassword"
                        + "&passiveMode=true&stepwise=false")
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