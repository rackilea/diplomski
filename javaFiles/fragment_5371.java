public static void main(String[] args) throws IOException {
  TypeVariableName t = TypeVariableName.get("T").withBounds(U.class);
  TypeSpec type = TypeSpec.classBuilder("B")
      .addTypeVariable(t)
      .addSuperinterface(ParameterizedTypeName.get(ClassName.get(A.class), t))
      .build();
  JavaFile.builder("", type).build().writeTo(System.out);
}