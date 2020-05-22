public class OuterClass {

  private int nonStaticMember;

  private static int staticMember;

  public static void main(String[] args) {
    MyInterface myAnObj = new MyInterface(){ //why it works ?? in this case   
                                             //where is the outer object?

    @Override
    public void print() {
       //nonStaticMember is not visible in this scope
       //staticMember is visible in this scope
    }};     
  }
}