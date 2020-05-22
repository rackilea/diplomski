@Provides Fruit provideFruit(
        @Named("fruit-type") String fruitType,
        Provider<Apple> appleProvider,
        Provider<Orange> orangeProvider) {
    switch (fruitType) {
       case "apple":
           return appleProvider.get();
       case "orange":
           return orangeProvider.get();
    }
}