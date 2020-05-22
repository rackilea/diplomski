URL url = new URL("http://my.a.example.com/kf/urjlsjjsXVXXq6xXFXXX6/20jaa/jajc1agiCJFXXXXb8XVXXq6xXFXXX6.jpg?size=158385&height=79&width=50&hash=13e12eaa837ae8341e35cbde5ea544a");

try {
    String fileName = new File(url.getPath()).getName();
    String urlWithNoFileName = url.toString().replace(fileName, "");
    System.out.println("File Name within URL is: " + fileName);
    System.out.println("URL with File Name removed:\n" + urlWithNoFileName);
} 
catch (MalformedURLException ex) {
    //Do what you want with Exception.
}