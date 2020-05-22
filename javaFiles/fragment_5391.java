public void run()
  throws Exception
{
  // Get password of 2nd enum
  String result;
  result = decide(2, "PASSWORD");
  System.out.println(result);

  // Or username of 1st enum
  result = decide(1, "USERNAME");
  System.out.println(result);

} // run