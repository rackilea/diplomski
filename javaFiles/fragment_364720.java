public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pathToAppFolder = getExternalFilesDir(null).getAbsolutePath();
        filePath = pathToAppFolder + File.separator + "list.ser";
        //create the list