public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
{
  MyRespObject myrespObj= processSomething(request);
  response.reset();
  response.setHeader("Content-Type", "application/x-java-serialized-object");
  ObjectOutputStream outputToApplet;
  outputToApplet = new ObjectOutputStream(response.getOutputStream());
  outputToApplet.writeObject(myrespObj);
  outputToApplet.flush();
  outputToApplet.close();
}

private MyRespObject processSomething(HttpServletRequest request)
{
  ObjectInputStream inputFromApplet = new ObjectInputStream(request.getInputStream());
  MyCustomObject myObject = (MyCustomObject) inputFromApplet.readObject();
  //Do Something with the object you just passed
  MyRespObject myrespObj= new MyRespObject();
  return myrespObj;
}