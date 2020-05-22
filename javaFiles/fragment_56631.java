public class MainActivity extends AppCompatActivity implements AsynkTaskResponse {

      @Override
      protected void onCreate(Bundle savedInstanceState) {
           super.onCreate(savedInstanceState);
           setContentView(R.layout.activity_main);

          //Start Request
          RequestManager.requestPostExample requestPostExample = new RequestManager.requestPostExample(this, exampleID, exampleData);
          requestPostExample.response = this;
          requestPostExample.execute();

      }

      @Override
      public void resultPostExample(String result){
            //here you get the result of the asynktask
      }
}