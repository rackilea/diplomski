public class FaecherRowAdapter extends SimpleCursorAdapter {

private int layout;
private Context context;

public FaecherRowAdapter(Context context, int layout, Cursor c, String[] from, int[] to, int flags) {
    super(context, layout, c, from, to, flags);
    this.layout = layout;
    this.context = context;
}

@Override
public View newView(Context context, Cursor cursor, ViewGroup parent) {
    Cursor c = getCursor();

    final LayoutInflater inflater = LayoutInflater.from(context);
    View v = inflater.inflate(R.layout.faecher_row, parent, false);
    bindView(v, context, c);
    return v;
}

@Override
public void bindView(View v, Context context, Cursor c) {

    int fachNameColumn = c.getColumnIndex(MyDBHandlerFaecher.COLUMN_NAME);
    int fachRaumColumn = c.getColumnIndex(MyDBHandlerFaecher.COLUMN_RAUM);
    int fachFarbeColumn = c.getColumnIndex(MyDBHandlerFaecher.COLUMN_COLOR);

    String fachName = c.getString(fachNameColumn);
    String fachRaum = c.getString(fachRaumColumn);
    String fachFarbe = c.getString(fachFarbeColumn);

    //set the name of the entry
    TextView facheintrag = (TextView) v.findViewById(R.id.facheintrag);
    if (facheintrag != null){
        facheintrag.setText(fachName);
    }
    TextView raumeintrag = (TextView) v.findViewById(R.id.raumeintrag);
    if (raumeintrag != null){
        raumeintrag.setText(fachRaum);
    }
    TextView farbeintrag = (TextView) v.findViewById(R.id.farbeintrag);
    if (farbeintrag != null){
        farbeintrag.setText(fachFarbe);
    }
    }