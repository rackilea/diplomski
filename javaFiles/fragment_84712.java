//this will find the file in the package folder
URL cert = this.getClass().getResource("ts");
String path = cert.toString(); //this translate the url to file system location
if (path.startsWith("file:"))
path = path.substring("file:".length()+1,path.length()); //getting rid of file prefix as not needed
System.setProperty("javax.net.ssl.trustStore", path);