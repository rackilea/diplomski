TypeSpec.interfaceBuilder("MyInterface")
        .addJavadoc("Bla Bla Bla")
        .addMethod(MethodSpec.methodBuilder("testMethodWithComment")
                             .addJavadoc("blub blub blub")
                             .build())
        .build();