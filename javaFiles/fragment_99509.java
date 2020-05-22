int totque=0;    
rs = st.executeQuery("select * from question");
while(rs.next()){
   ++totque;
int qno= rs.getInt(1);
String qname= rs.getString(2);
String qnos=Integer.toString(qno);
%>
<tr>
    <td class="member"><%=qnos %></td>
    <td class="member"><%=qname %></td>
    <td><input name="<%=qnos %>" type="radio"  value="1" required/></td>
    <td><input name="<%=qnos %>" type="radio"  value="2" required/></td>
    <td><input name="<%=qnos %>" type="radio"  value="3" required/></td>
    <td><input name="<%=qnos %>" type="radio"  value="4" required/></td>
</tr>
<%
}%>
<tr>
   <td>&nbsp;</td>
   <td>&nbsp;</td>
   <td>&nbsp;</td>
   <td><input type="hidden" id="thisField" name="inputName" value="<%=totque %>"></td>
   <td><input type="submit" value="Submit" /></td>
   <td><input type="reset" value="Reset" /></td>
</tr>