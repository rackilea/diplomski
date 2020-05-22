Constructor cons = String.class.getConstructors ()[1]; // I chose the 2nd constructor
                                                        // arbitrarily
 Class[] params = cons.getParameterTypes ();
 System.out.println ("Number of params: " + params.length);
 Object[] cargs = new Object[params.length]; // array of nulls to pass to the 
                                             // constructor
 try {
   Object obj = cons.newInstance (cargs);
 } catch (IllegalArgumentException e1) {
   System.out.println (e1);
   e1.printStackTrace();
 } catch (InstantiationException e1) {
   System.out.println (e1);
   e1.printStackTrace();
 } catch (IllegalAccessException e1) {
   System.out.println (e1);
   e1.printStackTrace();
 } catch (InvocationTargetException e1) {
   System.out.println (e1);
   e1.printStackTrace();
 }