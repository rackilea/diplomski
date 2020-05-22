@Module
class ModelModule {

    @Provides 
    @Named("FirstInt")
    int provideInt() {
        return 1;
    }
}

@Module
class AnotherModule {

    @Provides 
    @Named("SecondInt")
    int provideInt() {
        return 1;
    }
}