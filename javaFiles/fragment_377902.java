public interface MyInterface<R extends BaseRequest> {
   public String getValue(R req);
}

public class MyInterfaceImpl implements MyInterface<SpecificRequest> {
   public String getValue(SpecificRequest req){ 
      //Impl
   }
}