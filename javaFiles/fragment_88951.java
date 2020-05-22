new ByteBuddy()
  .subclass(Object.class, ConstructorStrategy.Default.NO_CONSTRUCTORS)
  .name("my.company.GeneratedByByteBuddy")
  .defineField("a", int.class, Visibility.PRIVATE, FieldManifestation.FINAL)
  .defineConstructor(Arrays.<Class<?>>asList(int.class), Visibility.PUBLIC)
  .intercept(new Instrumentation() {
    @Override
    public InstrumentedType prepare(InstrumentedType instrumentedType) {
      return instrumentedType;
    }

    @Override
    public ByteCodeAppender appender(final Target instrumentationTarget) {
      return new ByteCodeAppender() {
        @Override
        public boolean appendsCode() {
          return true;
        }

        @Override
        public Size apply(MethodVisitor methodVisitor,
                          Context instrumentationContext,
                          MethodDescription instrumentedMethod) {
          StackManipulation.Size size = new StackManipulation.Compound(
            MethodVariableAccess.REFERENCE.loadFromIndex(0),
            MethodInvocation.invoke(new TypeDescription.ForLoadedType(Object.class)
              .getDeclaredMethods()
              .filter(isConstructor().and(takesArguments(0))).getOnly()),
            MethodVariableAccess.REFERENCE.loadFromIndex(0),
            MethodVariableAccess.INTEGER.loadFromIndex(1),
            FieldAccess.forField(instrumentationTarget.getTypeDescription()
              .getDeclaredFields()
              .named("a"))
              .putter(),
            MethodReturn.VOID
          ).apply(methodVisitor, instrumentationContext);
          return new Size(size.getMaximalSize(), instrumentedMethod.getStackSize());
        }
      };
    }
  })
  .make()
  .load(getClass().getClassLoader(), ClassLoadingStrategy.Default.INJECTION);