PersonController pc = new PersonController();
pc.getAllPeople().add(new Person("Joe"));
pc.getAllPeople().add(new Person("John"));
request.setAttribute("personController", pc);

String nextJSP = "/index.jsp";
RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
dispatcher.forward(request,response);