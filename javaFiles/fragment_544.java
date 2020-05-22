String parameter1 = request.getParameter(param1);
String parameter2 = request.getParameter(param2);
//call to service to generate the collection
//for example List<Employee>
List<Employee> employees  = someService(parameter1, parameter2);
//using google's gson
Gson gson = new Gson();
String json = new Gson().toJson(employees);
response.setContentType("application/json");
response.setCharacterEncoding("UTF-8");
response.getWriter().write(json);