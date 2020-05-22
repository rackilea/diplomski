public abstract class MyAbstractPresenter<T extends MyAbstractPresenter.CustomDisplay> extends Presenter<T>
 {
   public interface CustomDisplay extends View
   {
     //some methods
   }

   //I wanted to inject this element
   private final CustomObject myObj;

   public MyAbstractPresenter(T display, CustomObject obj)
   {
      super(display);
      myObj = obj;
   }
}