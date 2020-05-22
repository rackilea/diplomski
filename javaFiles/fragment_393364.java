@Provides
@Named("someName1")
    public Operacion provideSuma() {
        return new InteractorSuma();
    }

    @Provides
    @Named("someName2")
    public Operacion provideResta() {
        return new InteractorResta();
    }

    @Provides
    @Named("someName3")
    public Operacion provideDiv() {
        return new InteractorDivision();
    }

    @Provides
    @Named("someName4")
    public Operacion provideMult() {
        return new InteractorMultiplicacion();
    }