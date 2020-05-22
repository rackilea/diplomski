public class AboutActivity extends DialogFragment {
  public void popup(Activity activity) {
    new AlertDialog.Builder(activity)
    .setIcon(android.R.drawable.ic_dialog_alert)
    .setTitle("About Us")
    .setMessage("Blah Blah Blah")
    .setCancelable(true)
    .setPositiveButton("Ok", null)
    .show();
  }
}