ServletContext context1 = session.getServletContext();
context1.setAttribute("contextAttribute", new Object());
ServletContext context2 = session.getServletContext().getContext("/SameWebApp");

System.out.println(context1.equals(context2)); // prints false, or 
System.out.println(context2.getAttribute("contextAttribute")); // prints null (at least they could have been clones)