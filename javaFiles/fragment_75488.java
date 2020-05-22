String personname = request.getParameter("personName"); //This will be received from an Ajax call
ArrayList list = ld.getLocation(personname);
String json = new Gson().toJson(list);
response.setContentType("text/json");
response.setHeader("Cache-Control", "no-cache");
response.getWriter().write(json);