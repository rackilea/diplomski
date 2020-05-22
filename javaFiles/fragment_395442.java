@ClassifierOne
public class MyClassOne implements MyInterface {
  // ...
}

@ClassifierTwo
public class MyClassTwo implements MyInterface {
 // ...
}

public class XY {
   private final MyInterface myClassOne;
   private final MyInterface myClassTwo;

   @Inject
   public XY ( @ClassifierOne MyInterface myClassOne, @ClassifierTwo MyInterface myClassTwo ) {
         this.myClassOne = myClassOne;
         this.myClassTwo = myClassTwo;
   }
}