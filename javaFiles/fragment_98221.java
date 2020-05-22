public class AdamTask extends AsyncTask<String, Void, String> {

private Activity activity; //activity is defined as a global variable in your AsyncTask

public AdamTask(Activity activity) {

    this.activity = activity;
}

public void showToast(final String toast)
    {
        activity.runOnUiThread(new Runnable() {
            public void run()
            {
                Toast.makeText(activity, toast, Toast.LENGTH_SHORT).show();
            }
        });
    }

...

}