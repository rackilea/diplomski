public abstract class MyConcretePresenter extends MyAbstractPresenter<MyConcretePresenter.CustomDisplay>
{
  public interface CustomDisplay extends MyAbstractPresenter.CustomDisplay
  {
     //some methods
  }

 @Inject  //it would get injected here instead.
 public MyConcretePresenter(CustomDisplay display, CustomObject obj)
 {
     super(display, obj);
 }
}