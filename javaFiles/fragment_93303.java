public class MainActivity extends AppCompatActivity {
    ListView list;
    ArrayList<Flick> flicks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = findViewById(R.id.list);
        flicks = new ArrayList<>();
        flicks.add(new Flick("Wizard of Oz", "Metro-Goldwyn-Mayer", "VARIOUS","1939", "", 98));
        ...
        flicks.add(new Flick("Jaws", "Universal", "Steven Spielberg", "1975", "", 97));

        CustomAdapter customAdapter = new CustomAdapter(this, R.layout.custom_layout, flicks);
        listt.setAdapter(customAdapter);
    }
    ...
}