import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

public class DemoDialogActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LayoutInflater lf = LayoutInflater.from(this);
        // This adds XML elements as a custom view (optional):
        final View customElementsView = lf.inflate(
                R.layout.activity_credentials, null);
        AlertDialog alert = new AlertDialog.Builder(this)
                // This adds the custom view to the Dialog (optional):
                .setView(customElementsView)
                .setTitle("This is the Title")
                .setMessage("This is the AlertDialog message (optional)")
                .setNegativeButton("Cancel",
                        new DialogInterface.OnClickListener() {

                            @Override
                            public void onClick(DialogInterface dialog,
                                    int which) {
                                // Cancel was clicked; do something
                                // Close Activity
                                finish();
                            }
                        })
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // OK was clicked; do something
                        // Close Activity
                        finish();
                    }
                }).create();

        // Show the dialog
        alert.show();
    }
}