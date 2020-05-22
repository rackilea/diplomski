public class MyClass extends Activity {

    private boolean mustScan = true;

    protected void onCreate(Bundle b) {
        if (mustScan) {
            // Just scan
            // Note: If you use a Thread with a while loop, use this:
            // while (true) {if (mustScan) {} }
        }
    }

    // This is the method you use to show the Dialog
    private void showResults (SomeResults here) {
        // Show the dialog
        // ...
        mustScan = false;
        // Also, in the OnClickListener of the buttons add "mustScan = true;"
    }