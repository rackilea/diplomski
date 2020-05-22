String xml = staticMethod("staticMethodName")
                            .withReturnType(String.class)
                            .in(Class.forName("com.package.className"))
                            .invoke();

return xml;