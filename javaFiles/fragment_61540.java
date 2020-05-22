public void writeDataToServer()
{
    URL downloadURL=new URL("example.com/example.pdf");
    URL serverIP=new URL("192.168.0.1");
    URLConnection downloadConnection=downloadURL.openConnection();
    URLConnection serverConnection=serverIP.openConnection();
    InputStream downloadStream=downloadConnection.getInputStream();
    OutputStream serverStream=serverConnection.getOutputStream();
    while((int r=downloadStream.read())!=-1)
    {
        serverStream.write(r);
    }
    downloadStream.close();
    serverStream.close();
}