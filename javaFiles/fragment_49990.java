public static Object Construct(Class type, Class[] params, Object[] values){
    //Create an object of any class
    try{
       Constructor con = type.getConstructor(params);
       con.setAccessible(true);
       Object o = con.newInstance(values);
       return o;
    }
    catch(Exception e){
       System.out.println("CONSTRUCTOR EXCEPTION"); 
       return null;
    }
}