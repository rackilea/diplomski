public class MyCustomReactViewManager extends SimpleViewManager<CustomView> {
   public static final String REACT_CLASS = "MyCustomReactViewManager";

   @Override
   public String getName() {
     return REACT_CLASS;
   }

   @Override
   public CustomView createViewInstance(ThemedReactContext context) {
     return new CustomView(context); //If your customview has more constructor parameters pass it from here.
   }