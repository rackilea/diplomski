if(val instanceof Integer) {
           Integer valInt = (Integer) val;
           System.out.println(valInt);
        } else if(val instanceof Scriptable) { //Rhino class embedes any js value
           Scriptable s = (Scriptable) val;
           String className = s.getClassName();// ECMA class name
           System.out.println(className);
           if(className.toLowerCase().equals("number")) {
              System.out.println(Context.toNumber(val)); 
           }
        }