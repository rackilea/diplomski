public static void main(String[] args) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        Class<?> cls = Person[].class;
        if(cls.isArray()){
            cls = cls.getComponentType();
        }
        String s = "{\"rootNode\":{\"classname\":\"" + cls.getName() + "\"},"
                + getAttributeClassnames(cls) + "}";
        s = s.replace("\",}", "\"}").replace("},}", "}}");
        System.out.println(s);
        s = mapper.generateJsonSchema(cls).getSchemaNode().put("type", "array")
                .put("classnames", s).toString();
        s = s.replace("\\", "").replace("\"{", "{").replace("}\"", "}");        
        System.out.println(s);
    }

static String getAttributeClassnames(Class<?> cls) {
    String s = "";      
        Field[] field = cls.getDeclaredFields();
        int i = 0;
        while (i < field.length) {              
            if (!(field[i].getType() == Boolean.class)
                    && !(field[i].getType() == Integer.class)
                    && !(field[i].getType() == Character.class)
                    && !(field[i].getType() == Byte.class)
                    && !(field[i].getType() == Short.class)
                    && !(field[i].getType() == Long.class)
                    && !(field[i].getType() == Float.class)
                    && !(field[i].getType() == Double.class)
                    && !(field[i].getType().isPrimitive())
                    && !(field[i].getType() == String.class)
                    && !(Collection.class.isAssignableFrom(field[i]
                            .getType()))
                    && !(Map.class.isAssignableFrom(field[i].getType()))
                    && !(Arrays.class.isAssignableFrom(field[i].getType()))) {
                if(field[i].getType() == cls){
                    if (i == field.length - 1) {
                        Class<?> name = null;
                        if(field[i].getType().isArray()){
                            name = field[i].getType().getComponentType();
                        }else{
                            name = field[i].getType();
                        }
                        s = s + "\"" + field[i].getName() + "\""
                                + ":{\"classname\":\""
                                + name.getName() + "\","
                                +"}";
                    } else {
                        Class<?> name = null;                       
                        if(field[i].getType().isArray()){
                            name = field[i].getType().getComponentType();
                        }else{
                            name = field[i].getType();
                        }
                        s = s + "\"" + field[i].getName() + "\""
                                + ":{\"classname\":\""
                                + name.getName() + "\","
                                + "}" + ",";
                    }

                }else{
                    if (i == field.length - 1) {
                        Class<?> name = null;
                        if(field[i].getType().isArray()){
                            name = field[i].getType().getComponentType();
                        }else{
                            name = field[i].getType();
                        }
                        s = s + "\"" + field[i].getName() + "\""
                                + ":{\"classname\":\""
                                + name.getName() + "\","
                                + getAttributeClassnames(name)
                                + "}";
                    } else {
                        Class<?> name = null;                       
                        if(field[i].getType().isArray()){
                            name = field[i].getType().getComponentType();
                        }else{
                            name = field[i].getType();
                        }
                        s = s + "\"" + field[i].getName() + "\""
                                + ":{\"classname\":\""
                                + name.getName() + "\","
                                + getAttributeClassnames(name)
                                + "}" + ",";
                    }
                }
            }
            i++;
        }
    return s;
}