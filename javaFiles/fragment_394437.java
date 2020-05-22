public void init(){
    List<Field> fields = new ArrayList<>();
    for(Class<?> klass=SomeClass.class; klass!=null; klass=klass.getSuperclass())
        Collections.addAll(fields, klass.getDeclaredFields());
    Field[] someFields = fields.toArray(new Field[0]);
}