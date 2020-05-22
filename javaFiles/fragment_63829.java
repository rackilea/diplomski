String fullyQualifiedClassName = getClassName();
if (fullyQualifiedClassName == null) {
  fullyQualifiedClassName = "Object";  //important if class was not found we need set to object -> otherwise there will not be imports for some reason
}
TypeName typeName = ClassName.bestGuess(fullyQualifiedClassName);
for (Model model : models) {
    typeSpecBuilder.addEnumConstant(prepareName(model), TypeSpec.anonymousClassBuilder("new CustomType<$T>($S, $S, $T.class)", typeName, string1, string2, typeName));
}