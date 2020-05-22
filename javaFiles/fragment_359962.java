private Map<String, MyMethod> mappings = new HashMap<String,MyMethod>();

    static{
        mappings.put("method1", new MethodOne());
        //.. other mappings
    }

   public String methodCaller(String methodName) throws SQLException, IOException
   {
      MyMethod myMethod = mappings.get(methodName);
      return myMethod.call();
   }