doExecute(){

 HttpSssion session=request.getSession();
 Object id =session.getAttribute("Order_ID");
 session.removeAttribute("Order_ID");
}