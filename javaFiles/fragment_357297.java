<%
File f=new File("c:\\Folder\\1.jpg");
if(f.delete())
out.println("Sucessfully deleted file");
else
out.println("Error in deleting file");
%>