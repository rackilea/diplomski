public class MyActivity extends Activity {

    ArrayList<HashMap<String, String>> arraylist;
    MyApplication mApplication;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        mApplication = (MyApplication)getApplication();

        //how to assign list data
        mApplication.setArrayListMapData(arraylist);


        //how to get same list data
        arraylist = mApplication.getArrayListMapData();

        super.onCreate(savedInstanceState);
    }
}