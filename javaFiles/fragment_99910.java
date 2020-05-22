public static void printType(Object o){
  type = o.getClass();
  fields = type.getDeclaredFields()
  System.out.println("The type of the object is : " + type);
  System.out.println("The fields of this type of class is : " + fields);
}