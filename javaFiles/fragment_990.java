public class MainActivity extends AppCompatActivity {

    List<ListModel> listModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listModel = new ArrayList<>();

        listModel.add(new ListModel(view, "url"));



    }
}