public class MainActivity extends AppCompatActivity {

private String JSON_RESULT_API_1 = "";
private String JSON_RESULT_API_2 = "";
private JSONTask mJsonTask;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    //make api 1
    mJsonTask = new JSONTask(Constants.URL_with_API_1, mOnTaskCompleted);
    mJsonTask.execute("URL_with_API_1");

    //make api 2
    mJsonTask = new JSONTask(Constants.URL_with_API_2, mOnTaskCompleted);
    mJsonTask.execute("URL_with_API_2");

}

public void onHouse(View view) {
    String activity_title = getResources().getString(R.string.title2);
    Intent intent = new Intent(MainActivity.this, DisplayDataActivity.class);
    Bundle extras = new Bundle();
    extras.putString("title", activity_title);
    extras.putString("JSON_Object", JSON_RESULT_API_1);
    intent.putExtras(extras);
    startActivity(intent);
}

public void onFood(View view) {
    String activity_title = getResources().getString(R.string.title1);
    Intent intent = new Intent(MainActivity.this, DisplayDataActivity.class);
    Bundle extras = new Bundle();
    extras.putString("title", activity_title);
    extras.putString("JSON_Object", JSON_RESULT_API_2);
    intent.putExtras(extras);
    startActivity(intent);
}


  OnTaskCompleted mOnTaskCompleted = new OnTaskCompleted() {
    @Override
    public void onTaskOne(String result) {
        JSON_RESULT_API_1 = result;
    }

    @Override
    public void onTaskTwo(String result) {
        JSON_RESULT_API_2 = result;
    }
    };
    }