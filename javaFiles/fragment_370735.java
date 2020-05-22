public class MainActivity extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {

        StrtBtn.setOnClickListener(
            new Button.OnClickListener() {
                public void onClick(View v) {
                    // I want to start the function on another thread here
                    myTask = new MyTask();
                    myTask.execute();
                }
            });

    StpBtn.setOnClickListener(
            new Button.OnClickListener() {
                public void onClick(View v) {
                    // I want to stop the function
                    message = "StopVideo";
                    myTask.cancel(true);
                }
            });
    }

    public void MyFunction() {
        // whatever
    }


    private class MyTask extends AsyncTask<Void, Void, Void> // Error: class 'MyTask' is public, should be declared in a file named 'MyTask.Java'
    {
        protected Void doInBackground(Void... params) {
            while (!isCancelled()) {
                // my code here to call the function here
            }
            return null;
        }
    }
}