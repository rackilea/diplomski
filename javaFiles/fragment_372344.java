int rc = connection.getResponseCode();
if(rc==200)
{
    //no http response code error
    //read the result from the server
    rd = new BufferedReader(new InputStreamReader(connection.getInputStream()));
    sb = new StringBuilder();
    //get the returned data too
    returnString=sb.toString();
}
else
{
    System.out.println("http response code error: "+rc+"\n");
}