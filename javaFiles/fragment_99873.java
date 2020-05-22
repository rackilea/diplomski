interface Service {
   void process(Request visitor);
}
interface RequestVisitor {
   void visitMyRequest(MyService service);
   void visitYourRequest(YourService service);
   void visitTheOtherRequest(TheOtherService  service);
}
interface Request extends RequestVisitor { /* and any extra methods required for request*/ }
public class MyService implements Service {
   public process(Request r) {r.visitMyRequest(this);}
   public void doSpecialMyProcessing(MyRequest request) { /* your code using MyRequest*/ }
}
public class YourService implements Service {
   public process(Request r) {r.visitYourRequest(this);}
   public void doSpecialYourProcessing(YourRequest request) { /* your code using YourRequest */ }
}
public class MyRequest implements Request {
   void visitMyRequest(MyService service) {
      service.doSpecialMyProcessing(this);
   }
   void visitYourRequest(YourService service) {
      throw new UnsupportedOperation("Cannot call visitYourRequest in MyRequest!");
   }
   void visitTheOtherRequest(TheOtherService  service) {
      throw new UnsupportedOperation("Cannot call visitTheOtherRequest in MyRequest!");
   }
}
public class YourRequest implements Request {
   void visitMyRequest(MyService service) {
      throw new UnsupportedOperation("Cannot call visitMyRequest in YourRequest !");
   }
   void visitYourRequest(YourService service) {
      service. doSpecialYourProcessing(this);
   }
   void visitTheOtherRequest(TheOtherService  service) {
      throw new UnsupportedOperation("Cannot call visitTheOtherRequest in YourRequest !");
   }
}