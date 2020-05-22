Object[] parameters ={new Object()}; // lets say this object array is null
    Class clas = Class.forName("AClass");
    Object anObject = clas.newInstance();

    Object[] param ={parameters};

    Method someMethod = clas.getDeclaredMethod("someMethod", parameters.getClass());
    someMethod.invoke(anObject, param);