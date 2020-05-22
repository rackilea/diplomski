public class ImageUtils {

   private static int empty = -1;

   public static int getEmpty(Context context) {
        if(empty == -1)
          empty = context.getResources().getIdentifier("dotted_circle", "resId", "en.deco.android.livehud");

        return empty;
   }

}