<%
HashMap hm=(HashMap)session.getAttribute("hm");
Set<String> keyset=hm.keySet();
Iterator itr = keyset.iterator();
while (itr.hasNext()) {
    String key = itr.next();
    ArrayList<String> ls = (ArrayList)hm.get(key); 
    String item_id = ls.get(0);
    String name = ls.get(1);
    String unit_price = ls.get(2);
    String qty = ls.get(3);
    %>
    <tr>
      <td><%=item_id%></td>
      <td><%=name%></td>
      <td><%=unit_price%></td>
      <td><%=qty%></td>
    </tr>
<%
    } catch (Exception e) {
        e.printStackTrace();
 }
}