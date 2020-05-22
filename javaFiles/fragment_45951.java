<form method="post" action="ServletForm" onsubmit="return valiData();">
...
</form>

<script>
function valiData() {
  // validation here
  // presumably some sort of if statement, then
  return true; // if validation passes and you want to submit
  return false; // if validation fails and you want to cancel
}
</script>