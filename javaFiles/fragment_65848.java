Class cls=Class.forName("example");
Field[]f=cls.getDeclaredFields();
for(Field field : f){
     Class<?> type = field.getType()
     int numArrayDimensions= 0;
     while (type.isArray()){
        type = type.getComponentType();
        numArrayDimensions++;
     }
     if (! type.isPrimitive()){
         Package pkg = type.getPackage();
     }
     String className = getFormattedClassName(type, numArrayDimensions);

}

private String getFormattedClassName(Class<?> type, int numArrayDimensions){
         StringBuilder sb = new StringBuilder(type.getName());
         IntStream.range(0, numArrayDimensions).foreach(dimension -> sb.append("[]"));
         return sb.toString();
}