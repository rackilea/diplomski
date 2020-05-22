<!DOCTYPE html>
<html>
<head>
<script>
function load()
{
var elements = document.getElementsByClassName('child');
for(var i=0; i<elements.length; i++){
elements[i].style.display='none';
}
}
</script>
</head>
<body onload="load()">
<table>
    <tr>Trs wont appear below</tr>
    <tr class="child"><td>Child1</td></tr>
    <tr class="child"><td>Child2</td></tr>
<tr class="child"><td>Child3</td></tr>
<tr class="child"><td>Child4</td></tr>
</table>
</body>
</html>