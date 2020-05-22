public ArrayList<test> testing throws SomeException {
    Arraylist<test> arr = new ArrayList();
    if (somethingFails) { 
      String message = "an explanation of why the method failed";
      throw new SomeException(message);
    }
    return arr;
}