private String getHostName (InetAddress inaHost) throws UnknownHostException
    {
       try
       {
           Class clazz = Class.forName("java.net.InetAddress");
           Constructor[] constructors = clazz.getDeclaredConstructors();
           constructors[0].setAccessible(true);
           InetAddress ina = (InetAddress) constructors[0].newInstance();

           Field[] fields = ina.getClass().getDeclaredFields();
           for (Field field: fields)
           {
               if (field.getName().equals("nameService"))
               {
                   field.setAccessible(true);
                   Method[] methods = field.get(null).getClass().getDeclaredMethods();
                   for (Method method: methods)
                   {
                        if (method.getName().equals("getHostByAddr"))
                        {
                            method.setAccessible(true);
                            return (String) method.invoke(field.get (null), inaHost.getAddress());
                        }
                   }
               }
           }
       } catch (ClassNotFoundException cnfe) {
       } catch (IllegalAccessException iae) {
       } catch (InstantiationException ie) {
       } catch (InvocationTargetException ite) {
           throw (UnknownHostException) ite.getCause();
       }
       return null;
    }