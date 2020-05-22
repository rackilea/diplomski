class MyNameStrategy implements FieldNamingStrategy {

    @Override
    public String translateName(Field f) {
        if (f.getName().equals("response")) {
            return "CBE_GetNewSessionResponse";
        } else {
            return f.getName();
        }
    }
}