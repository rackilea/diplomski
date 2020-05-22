<script>
<% // Server-side code
    Calendar serverDate = Calendar.getInstance();
%>
var d = new Date(
    <%=serverDate.get(Calendar.YEAR)%>,
    <%=serverDate.get(Calendar.MONTH)%>,
    <%=serverDate.get(Calendar.DAY_OF_MONTH)%>,
    <%=serverDate.get(Calendar.HOUR_OF_DAY)%>,
    <%=serverDate.get(Calendar.MINUTE)%>,
    <%=serverDate.get(Calendar.SECOND)%>
);
var delta = d.getTime() - Date.now();
</script>