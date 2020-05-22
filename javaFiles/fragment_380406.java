public class JavascriptCheck {
   private final Context context;

   public JavascriptCheck(Context context) {
      this.context = context;
   }

   public void echo() {
       Log.d("JavascriptChecker", "javascript called");
   }

   public void hasStreetview() {
       pushStreetviewState(true);
   }

   public void hasNotStreetview() {
      pushStreetviewState(false);
   }

   private void pushStreetviewState(final boolean hasStreetview) {
       Log.d("JavascriptChecker", hasStreetview);
       // TODO do your stuff needed here
   }
}