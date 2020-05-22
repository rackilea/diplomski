@Provides
public AnAppleOfGold providesApple(Fizz fizz) {
  return new AppleOfGold(fizz);
}

@Provides
public Bosse providesBosse(Provider<Fizz> fizzProvider) {
  return new Bosse("Grab a hold of my beard", fizzProvider.get());
}

@Provides @Singleton
public Fizz providesFizz() {
  return new Fizz(Math.random());
}