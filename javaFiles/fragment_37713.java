<SCRIPT>
function sendParam(){
var item=   document.Form.item[document.Form.item.selectedIndex].value
//I need to send this value to the server side java code and process further
var url = "/urlToActionClass"
document.Form.acton = url;
document.Form.submit();
}
</SCRIPT>