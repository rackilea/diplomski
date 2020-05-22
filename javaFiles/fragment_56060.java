Injector injector = Guice.createInjector(new RunnerModule());

// possible input which you get from *somewhere* dynamically
Object object = 1.0;

TypeLiteral<?> matchedTypeLiteral = null;
for (Key<?> key : injector.getAllBindings().keySet()) {
  TypeLiteral<?> typeLiteral = key.getTypeLiteral();
  Type type = typeLiteral.getType();
  if (type instanceof ParameterizedType) {
    ParameterizedType parameterizedType = (ParameterizedType) type;
      if (parameterizedType.getRawType() == GenericDAO.class) {
        List<Type> actualTypeArguments =    Arrays.asList(parameterizedType.getActualTypeArguments());
        if (actualTypeArguments.get(0) == object.getClass())
          matchedTypeLiteral = typeLiteral;
    }
  }
};

Runner<?, ?> runner = new Runner<>((GenericDAO<?, ?>) injector.getInstance(Key.get(matchedTypeLiteral)));
System.out.println(runner.dao.getClass()); // IntegerDAO.class