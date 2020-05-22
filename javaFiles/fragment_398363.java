Field[] fields = Example.class.getDeclaredFields();
for (Field field : fields) {
    if (field.getClass() == Date.class) {
        //...
    }
}