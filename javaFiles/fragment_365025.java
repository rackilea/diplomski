public class TestActivity extends ActionBarActivity {

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    if (savedInstanceState == null) {
        showAlertDialog();
    }
}

private void showAlertDialog() {
    // code to show alert dialog.
}