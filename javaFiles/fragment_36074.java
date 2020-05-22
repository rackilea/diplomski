String defaultGreeting;
String defaultName;
 public void init(ServletConfig config) 
    throws ServletException {
  if ((defaultGreeting = getInitParameter("greeting")) == null)
    defaultGreeting = "Hello";
   if ((defaultName = getInitParameter("person")) == null)
    defaultName = "World";
}