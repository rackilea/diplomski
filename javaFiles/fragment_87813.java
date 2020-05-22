TypeToken<List<String>> typeToken = new TypeToken<List<String>>(){};

System.out.println("typeToken.getRawType() = " + typeToken.getRawType());
Type type = typeToken.getType();
System.out.println("typeToken.getType() = " + type);
if (type instanceof ParameterizedType) {
  Type[] typeArguments = ((ParameterizedType) type).getActualTypeArguments();
  System.out.println("typeArguments = " + Arrays.toString(typeArguments));
}