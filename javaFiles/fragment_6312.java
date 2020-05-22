java.lang.reflect.Field[] allFields = MyContainer.class.getDeclaredFields();        
MyContainer obj = new MyContainer();

for (java.lang.reflect.Field field : allFields) {

    if ( MyType.class == field.getType() ){                 

        field.setAccessible(true);              
        MyType myAux = (MyType) field.get(obj);             
        String dowhatever = myAux.getVar2();    

    }
}