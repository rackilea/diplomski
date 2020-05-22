public class MainActivity extends Activity {
    private boolean result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        showConfirmationBox("Are you sure you want to do this", this);
    }

    private doOnTrueResult() {
        result = true;
        //do something
    }

    private doOnFalseResult() {
        result = false;
        //do something else
    }

    public void showConfirmationBox(String messageToShow, final Context context) {

        // prepare the alert box
        AlertDialog.Builder alertbox = new AlertDialog.Builder(context);

        // set the message to display
        alertbox.setMessage(messageToShow);

        // set a positive/yes button and create a listener
        alertbox.setPositiveButton("Yes",
        new DialogInterface.OnClickListener() {

            // do something when the button is clicked
            public void onClick(DialogInterface arg0, int arg1) {
                Toast.makeText(context,
                    "'Yes' button clicked", Toast.LENGTH_SHORT)
                    .show();
                doOnTrueResult();
            }
        });

        // set a negative/no button and create a listener
        alertbox.setNegativeButton("No", new DialogInterface.OnClickListener() {

            // do something when the button is clicked
            public void onClick(DialogInterface arg0, int arg1) {
                Toast.makeText(context, "'No' button clicked",
                Toast.LENGTH_SHORT).show();
                doOnFalseResult();
            }
        });

        // display box
        alertbox.show();
    }
}