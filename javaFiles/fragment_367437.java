Field field = loaded.getDeclaredField("names");
    Type fieldType = field.getGenericType();
    Assert.assertTrue(fieldType instanceof ParameterizedType);
    ParameterizedType genericFieldType = (ParameterizedType)fieldType;
    Assert.assertEquals(Dummy.class, genericFieldType.getActualTypeArguments()[0]);
    System.out.println(genericFieldType.getRawType());
    System.out.println(genericFieldType.getActualTypeArguments()[0]);