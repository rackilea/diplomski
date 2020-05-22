/** In module: install(new FactoryModuleBuilder().build(SomeClass.Factory.class)); */
public class SomeClass {
  public interface Factory {
    SomeClass create(int s);
  }

  private final int s;

  @Inject
  SomeClass(/* ..., */ @Assisted int s) {
    this.s = s;
  }

  public void doWork() { /* ... */ }
}