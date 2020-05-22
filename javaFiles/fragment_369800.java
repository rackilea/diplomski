<script>
<% // Server-side code
    Calendar serverDate = Calendar.getInstance();
%>
var d = new Date(
    2014,
    11,
    23,
    9,
    54,
    27
);
var delta = d.getTime() - Date.now();
</script>