builder.defineField("desiredField", 
          DispatcherInvocationHandler.class, 
          Visibility.PRIVATE, FieldManifestation.FINAL)
       .defineConstructor(Visibility.PUBLIC)
       .withParameters(String.class)
       .intercept(MethodCall.invokeSuper() // Given such a constructor exists
         .andThen(FieldAccessor.ofField("desiredField").setsArgumentAt(0)))
       .make()
       .load(BytebuddyProxyGenerator.class.getClassLoader())
       .getLoaded();