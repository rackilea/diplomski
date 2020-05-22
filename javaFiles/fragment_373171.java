String emails = "id@yahoo.com  ,  my@gmail.com ,  luigi@microsoft.com";
emails = emails.trim();  // get rid of spaces.
String[] parts = emails.split(",");  // emails array.

for (String email : parts) 
{
    String temp = email.substring(email.indexOf("@") + 1); // e.g. @google.com
    String serverName = temp.substring(0, temp.indexOf("."));  // e.g. google
    System.out.println(serverName);  //prints google
}