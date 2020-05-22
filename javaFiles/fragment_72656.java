public class CustomBinding {

   @BindingAdapter({"imageUrl"})
   public static void loadImage(LinearLayout layout, Drawable drawable) {
       if (drawable != null) {
           if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
               layout.setBackground(drawable);
           } else {
               layout.setBackgroundDrawable(drawable);
           }
       }
   }
}