int port = 8080;
String context_path = "/";
File tmp_directory = "C:\\some-custom-path\\";
String war_path = "C:\\path-to-a\\file.war";

WebAppContext app = new WebAppContext();
app.setContextPath( context_path );
app.setWar( war_path );
app.setTempDirectory( tmp_directory );

Server server = new Server( port );
server.setHandler( app );
server.start();
server.join();