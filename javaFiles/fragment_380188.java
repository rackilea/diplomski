public static void printValues(Object object, String referenceName) {
        Method[] methods = object.getClass().getMethods();
        for(Method method : methods){
            if(isGetter(method))
                try {

                if(method.getReturnType().getSimpleName().contentEquals("Date"))
                {
                    if(method.invoke(object)!=null)
                    {
                        System.out.println(referenceName+"." + method.getName().replace("get", "set")+"(new Date(\""+method.invoke(object)+"\"));");
                    }
                }
                else if(method.getReturnType().getSimpleName().contentEquals("long"))
                {
                    System.out.println(referenceName+"." + method.getName().replace("get", "set")+"("+method.invoke(object)+"L);");
                }
                else if(method.getReturnType().getSimpleName().contentEquals("String"))
                {
                    if(method.invoke(object)!=null)
                    {
                        System.out.println(referenceName+"." + method.getName().replace("get", "set")+"(\""+method.invoke(object)+"\");");
                    }

                }
                else if(method.getReturnType().getSimpleName().contentEquals("BigInteger"))
                {
                    if(method.invoke(object)!=null)
                    {
                        System.out.println(referenceName+"." + method.getName().replace("get", "set")+"(new BigInteger(\""+method.invoke(object)+"\"));");
                    }
                }
                else if(method.getReturnType().getSimpleName().contentEquals("double"))
                {
                    System.out.println(referenceName+"." + method.getName().replace("get", "set")+"("+method.invoke(object)+");");
                }
            } catch (IllegalAccessException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IllegalArgumentException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
      }
}

public static boolean isGetter(Method method){
      if(!method.getName().startsWith("get"))      return false;
      if(method.getParameterTypes().length != 0)   return false;  
      if(void.class.equals(method.getReturnType())) return false;
      return true;
    }