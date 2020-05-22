public class WindowsAbsolutePath {

    public static void main(String[] args) throws Exception {
        FakeFtpServer fakeFtpServer = new FakeFtpServer();
        fakeFtpServer.setServerControlPort(2222);

        fakeFtpServer.addUserAccount(new UserAccount("ftpUser", "ftpPassword", "C:\\home"));
        WindowsFakeFileSystem fileSystem = new WindowsFakeFileSystem();
        // if the user home is not part of a `FileEntry` it must be explicit added
        fileSystem.add(new DirectoryEntry("C:\\home"));
        fileSystem.add(new FileEntry("C:\\a\\ftp\\some_file.xml", "windows absolute path"));

        fakeFtpServer.setFileSystem(fileSystem);
        fakeFtpServer.start();

        CamelContext context = new DefaultCamelContext();
        RouteBuilder rb = new RouteBuilder() {
            @Override
            public void configure() throws Exception {
                // directory with absolute Windows path
                from("ftp://ftpUser@localhost:2222/C:/a/ftp?password=ftpPassword"
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