List<Tour> listOfTours = ...;
Tours tours = new Tours(listOfTours);
response.setContentType("application/json");
PrintWriter out = response.getWriter();
out.print((new Gson()).toJson(tours));
out.flush();