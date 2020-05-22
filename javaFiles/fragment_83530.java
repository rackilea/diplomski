public class AssertionTest {            
  private boolean productionCode(){
    System.out.println("Prodution code executed");
    return true;
  }

  private void assertion() {
    assert productionCode();
  }
}