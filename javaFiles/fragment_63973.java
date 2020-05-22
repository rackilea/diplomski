<script>
// stores the java value
localStorage['someKey'] = "<%= myJavaVar %>";

// do manipulations
var s2 = "value:" + localStorage['someKey'];

// very cheap display
document.body.appendChild(document.createTextNode(s2));  
</script>