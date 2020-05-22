public HashMap initEditText(Context context){
    HashMap list = new HashMap();
    Field[] fields = context.getClass().getDeclaredFields();

    for (Field field : fields){
        field.setAccessible(true); //Add this line here
        if(field.getName().startsWith("e_")){
            String word = field.getName().substring(2);
            String firsCaract = word.substring(0, 1).toUpperCase();