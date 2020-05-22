function lookup() {
'<s:if test="uselist.size()>0">'
  <% List<UserOrganization> el = (List<UserOrganization>) request.getAttribute("uselist");%>
<% for (int i = 0; i < el.size(); i++) {%>    
    var email<%out.print(i);%>="<%out.print(el.get(i).getUser_1().getEmailId());%>";
    $.ajax({
        type: "POST",
        url: "EveConnectOutletsCount",
        data: {
            email:email<%out.print(i);%>
        },
        success: function(data) {
            $('#ec<%out.print(i);%>').html(data)
        }
    });
<% }%>
'</s:if>'
}