String foo = request.getParameter("foo");
String bar = request.getParameter("bar");

response.setContentType("application/pdf");

InputStream input = generatePdfSomehowBasedOn(foo, bar);
OutputStream output = response.getOutputStream();
// Now just write input to output.