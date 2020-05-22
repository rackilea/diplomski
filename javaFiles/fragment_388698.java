public class SutTss extends Sut {
  @Override
  public Foo methodToTest(Param param) {  // visibility loosen
    return super.methodToTest(param);
  }
}