ParameterizedTypeName subType = ParameterizedTypeName.get(Pair.class, 
                                                          Boolean.class,
                                                          Object.class);
ClassName string = ClassName.get("java.lang", 
                                 "String");
ClassName hashMap = ClassName.get("java.util", 
                                  "HashMap");
ParameterizedTypeName mainType = ParameterizedTypeName.get(hashMap, 
                                                           string,
                                                           subType);

FieldSpec.builder(mainType, 
                  "mHashMap",
                  Modifier.PRIVATE,
                  Modifier.FINAL)
         .initializer("new HashMap<>()")
         .build();