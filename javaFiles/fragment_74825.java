public String[] nombreSecciones = {"Perfil", "Juego", "Instrucciones", "Info"};
ListView listView;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    listView = (ListView) findViewById(R.id.secciones);

    ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, nombreSecciones);
    listView.setAdapter(adapter); 
}