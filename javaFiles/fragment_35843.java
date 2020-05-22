@Singleton
public class MySingleton {
  private AnotherClassInstanceThatIWantToInjectHere anotherClassInst_BlaBla;

  @Inject public MySingleton(AnotherClassInstanceThatIWantToInjectHere anotherClassInst_BlaBla) {
    this.anotherClassInst_BlaBla = anotherClassInst_BlaBla;
    anotherClassInst_BlaBla.doSmth();
  }
}