for (String parameterName : request.getParameters()) {
  String value = request.getParameter(parameterName);
  // store parameter values in any structure you need
  ...
}
// here you cann access any class from your web application to perform
// DB operations.
...
// to propagate result to client obtain an OutputStream from response object
// and simply write data to it
OutputStream os = response.getOutputStream();
os.write(your data);