@GinModules(...)
interface MyGinjector extends Ginjector {

   public void injectEntryPoint(AAA entryPoint);

   ...
}

public class AAA implements EntryPoint {
   @Inject private BBB bbb; // field injection works
   private CCC ccc;

   @Inject void setCcc(CCC ccc) { this.ccc = ccc; } // and of course method injection

   public onModuleLoad() {
      MyGinjector injector = GWT.create(MyGinjector.class);
      injector.injectEntryPoint(this);
      ...
   }
}