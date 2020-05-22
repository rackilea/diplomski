private Field field;

    @Test(expected=IllegalArgumentException.class)
    public void testAccept() throws Exception {
      Class<?> clazz = Field.class;
      Constructor<?> [] constructors = clazz.getDeclaredConstructors();

      for(Constructor cons: constructors) {
          cons.setAccessible(true);
          field = (Field) cons.newInstance();
      }

      DefaultToStringBuilder builder = new DefaultToStringBuilder(new Object());
      builder.accept(field);

      assertNotNull(builder);
    }