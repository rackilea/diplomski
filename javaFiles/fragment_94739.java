<%
String whichRadio = request.getParameter("myradio");
String r1checked = "";
if (whichRadio.equals("1")) r1checked = " checked";
String r2checked = "";
if (whichRadio.equals("2")) r2checked = " checked";
%>
<input type=radio name=myradio value="1"<%= r1Checked %>>
<input type=radio name=myradio value="2"<%= r2Checked %>>