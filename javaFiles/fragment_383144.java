MyCustomObject myObject = new MyCustomObject()
ObjectOutputStream outputToServlet;
outputToServlet = new ObjectOutputStream(servletConnection.getOutputStream());
outputToServlet.writeObject(myObject);
outputToServlet.flush(); //Cleanup
outputToServlet.close();