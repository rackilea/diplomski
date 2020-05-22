public String validateForNull(MyClass myclass) throws IllegalArgumentException, IllegalAccessException {
        // Get the attributes of the class
        Field[] fs = myclass.getClass().getFields();
        for(Field f : fs) {
            // make the attribute accessible if it's a private one
            f.setAccessible(true);

            // Get the value of the attibute of the instance received as parameter  
            Object value = f.get(myclass);
            if(value == null) {
                return f.getName();
            }
        }
        return null;
     }