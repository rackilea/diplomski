public class MainActivity extends AppCompatActivity {
    // 1
    private ArrayList<Todo> todolist;
    private Todoadapter adapter;
    private EditText edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView view = (ListView)findViewById(R.id.listview);
        edit = (EditText)findViewById(R.id.editText);
        Button button = (Button)findViewById(R.id.button);

        Todo eat = new Todo("Eat ");
        Todo sleep = new Todo("Sleep");

        todolist = new ArrayList<>();
        todolist.add(eat);
        todolist.add(sleep);

        adapter = new Todoadapter(this,R.layout.custom_adapter_layout,todolist);
        view.setAdapter(adapter);
    }
    // 2
    public void addTodo(View view){
        // 3
        todolist.add(new Todo(edit.getText().toString()));
        // 4
        adapter.notifyDataSetChanged();
    }
}