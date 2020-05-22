ArrayList<String> fruits;
ListAdapter myAdapter;

protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    fruits = new ArrayList<String>();
    fruits.add("apple");
    fruits.add("banana");
    fruits.add("mango");
    fruits.add("orange");
    fruits.add("peach");

    myAdapter = new CustomAdapter(this,fruits);
    ....
}

public void onClick (View view) {
   final EditText input = (EditText) findViewById(R.id.editText);
   String name = input.getText().toString();
   fruits.add(name);
   myAdapter.notifyDataSetChanged();
}