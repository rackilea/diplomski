public class AnimalStateModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(Animal.class).to(Cat.class);
    }
}