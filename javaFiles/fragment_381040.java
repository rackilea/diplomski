@Provides
@Blue
//@Singleton //optional, depends on your use case
public Fizz provideFirstFizz() {
    return new Fizz(true, "oh yeah", null);
}