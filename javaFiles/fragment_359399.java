Field[] fields = R.string.class.getFields();
    for(final Field field : fields) {
       String name = field.getName(); //name of string
       try{
           int id = field.getInt(R.string.class); //id of string
       }catch (Exception ex) {
           //do smth
       }
    }