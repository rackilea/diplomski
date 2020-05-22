Method[] m = class.getMethods();
      for(int i = 0; i < m.length; i++) {

         // returns te declaring class
         Class dec = m[i].getDeclaringClass();

         // displays all methods
         System.out.println("Method = " + m[i].toString());
         System.out.println(" Declaring class: " + dec.toString());
      }