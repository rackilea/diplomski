class Check 
{
  private static HashMap<String,String> map = new HashMap<String, String>();
  static
  {
    System.out.println("***********In static block***********");
    Check.map.put("1", "One");
    Check.map.put("2","Two");
  }

  private static Check check = new Check(); 

  private Check()
  {
    System.out.println("Map Contains "+map.get("1"));
  }

  ...
}