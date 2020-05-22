public class ButtonDialogs extends DialogFragment {

   private Context context;

   public ButtonDialogs(Context context) {
      this.context = context;
   }

   public void getWarning(final Context context) {
      final AlertDialog mAlertDialog = new AlertDialog.Builder(context).create();
      SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
      final SharedPreferences.Editor editor = preferences.edit();
      //do stuff
      mAlertDialog.show();
   }
}