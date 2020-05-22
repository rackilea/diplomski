String myvalue = request.getParameter("myvalue");

if ( myvalue.equals("blah" )) {
 out.print("<h3>You submitted the page, my value = " + myvalue + "</h3>" );

} else {
  out.print("<h3>Page not submitted yet, my value = " + myvalue + "</h3>" );
}