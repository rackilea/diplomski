try {
    java.lang.Exception exception = new java.lang.Exception();
    throw exception;
}
catch(Exception e)
{
    System.out.println("I caught one!, Here's it's info: ");
    e.printStackTrace();
}