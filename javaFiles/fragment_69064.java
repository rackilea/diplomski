String jspClassName = findJspClassForJSP("your.jsp");
Class jspClass = Class.forName(jspClassName);
Servlet jspServlet = (Servlet)jspClass.newInstance();
MyServletRequest req = new MyServletRequest();
MyServletResponse resp = new MyServletResponse();
jspServlet.init();
jspServlet.service(req, resp);
jspServlet.destroy();
String results = reps.getContent();