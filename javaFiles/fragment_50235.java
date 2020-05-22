<script>
function printAll()
{
  var html = '<ul>';
  <c:foreach value = "item" items = '${sessionScope.notification}'>
    html += '<li>${item}</li>';
  </c:foreach>
  html += '</ul>';
  display(html);
}
</script>

<a href = "javascript:printAll();">Print</a>