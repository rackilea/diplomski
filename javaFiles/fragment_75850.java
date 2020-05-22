<table cellspacing='0' border="1" >
<% 
 String fName = "c://list_win_instances.csv";
 String thisLine; 
 int count=0; 
 FileInputStream fis = new FileInputStream(fName);
 DataInputStream myInput = new DataInputStream(fis);
 int i=0; 

while ((thisLine = myInput.readLine()) != null)
{
String strar[] = thisLine.split(",");
%><tr><%
for(int j=0;j<strar.length;j++)
 {
if(i!=0) 
 {
out.print("<td> " +strar[j]+ "</td> ");
 }
else
{
out.print(" <td> <b>" +strar[j]+ "</b> </td> ");
}
i++;
} 
%></tr><%
} 
 %>
</table>