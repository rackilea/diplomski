ClassName containerClassName = ClassName.get(Container.class);
TypeName wildcardTypeName = WildcardTypeName.subtypeOf(ImportantInterface.class);
ParameterizedTypeName parameterTypeName = ParameterizedTypeName.get(containerClassName, wildcardTypeName);

classBuilder.addMethod(MethodSpec.constructorBuilder()
        .addModifiers(Modifier.PUBLIC)
        .addParameter(parameterTypeName, "cargo")
        .addStatement(CodeBlock.builder()
                .addStatement("//1. Collect Underpants")
                .addStatement("//2. ...")
                .addStatement("//3. Profit!!!")
                .build())