function getData()
{
var client;
var data;
var url_action="/temp/getData";
if(window.XMLHttpRequest)
{
    client=new XMLHttpRequest();
}
else
{
    client=new ActiveXObject("Microsoft.XMLHTTP");
}
client.onreadystatechange=function()
{
    if (client.readyState==4 && client.status==200)
    {
         document.getElementById("response").innerHTML=client.responseText; 
    }
};
data="name="+document.getElementById("name").value+"&file="+document.getElementById("filname").value;
client.open("POST",url_action,true);
client.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
client.send(data);
}


Servlet post method

protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // TODO Auto-generated method stub
    PrintWriter out=response.getWriter();
    log.info("Good");
    out.println("Good to go");
}