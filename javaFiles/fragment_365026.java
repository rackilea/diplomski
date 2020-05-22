public class TestActivity extends ActionBarActivity {

private static boolean isAlertDialogShownBefore = false;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    if (!isAlertDialogShownBefore) {
        showAlertDialog();
        isAlertDialogShownBefore = true;
    }
}

private void showAlertDialog() {
    // code to show alert dialog.
}

@Override
public void onBackPressed() {
    isAlertDialogShownBefore = false;
    super.onBackPressed();
}