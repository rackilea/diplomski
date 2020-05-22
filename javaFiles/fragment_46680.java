private ListView listView;
private FloatingActionButton fab;
private Cursor cursor;
private SQLiteDatabase db;
boolean isAvatar;
String nameText;

public FragmentList() {
    // Обязателен открытый/публичный пустой конструктор
}

@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,
                         Bundle savedInstanceState) {

    View v = inflater.inflate(R.layout.fragment_list, container, false);
    fab = (FloatingActionButton) v.findViewById(R.id.fab);
    listView = (ListView) v.findViewById(R.id.listView);


    //обработка добавления человека - нажатие на fab
    fab.setOnClickListener(new View.OnClickListener() {
        @Override public void onClick(View v) {
            //TODO добавление!!!
            Toast.makeText(v.getContext(), "Новая запись добавлена", Toast.LENGTH_SHORT).show();
        }
    });

    //создание курсора
    try{
        SQLiteOpenHelper databaseHelper = new DatabaseHelper(v.getContext());

       //////**** make following change  it might work*****//// 

       db = databaseHelper.getWritableDatabase();
        Cursor cursor = db.query("PEOPLE", new String[] {"_id", "NAME", "CHECKBOX"}, null, null, null, null, null);
        CursorAdapter listAdapter = new SimpleCursorAdapter(v.getContext(), R.layout.list_item, cursor, new String[]{"NAME", "CHECKBOX"}, new int[]{R.id.name, R.id.checkBox}, 0);
        listView.setAdapter(listAdapter);

    } catch (SQLiteException e){
        Toast.makeText(v.getContext(), "База данных недоступна", Toast.LENGTH_SHORT).show();
    }
    return v;