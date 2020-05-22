<script>
function myFunction() {
var x = document.getElementById("mySelect").value;
var y = "your value";
document.getElementById("demo").innerHTML = "You selected: " + x;
window.location = "http://www.yoururl.com"; //redirect normally on changes

/* you can also check select value with condition and redirect like this 
if (X.toLowerCase() === y.toLowerCase())
{
  window.location = "http://www.yoururl.com";
}
*/

}
</script>