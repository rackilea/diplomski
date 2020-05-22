@Override
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.listagps);

LayoutInflater li = getLayoutInflater();
View vListItems = li.inflate(R.layout.listagps_item, null);

    TextView nomelista=(TextView) vListItems.findViewById(R.id.nomelista);
    TextView latitudinelista=(TextView) vListItems.findViewById(R.id.latitudinelista);
    TextView longitudinelista=(TextView) vListItems.findViewById(R.id.longitudinelista);


    // CREAZIONE LISTA PUNTI GPS SU LAYOUT LISTAGPS

    ListView posizionigps=(ListView)findViewById(R.id.listagps);

    final listagpsdb db = new listagpsdb(getApplicationContext());

    db.open();

    Cursor c=listagpsdb.fetchProducts();
    startManagingCursor(c);

@SuppressWarnings("deprecation")
    SimpleCursorAdapter adapter=new SimpleCursorAdapter (
            this,
            vListItems,
            c,
            new String[]{listagpsdb.PositionsMetaData.POSITIONS_NAME_KEY,listagpsdb.PositionsMetaData.POSITIONS_LONGITUDE_KEY,listagpsdb.PositionsMetaData.POSITIONS_LATITUDE_KEY},
            new int []{R.id.nomelista,R.id.longitudinelista,R.id.latitudinelista});

    posizionigps.setAdapter(adapter);

    int nomecol=c.getColumnIndex(listagpsdb.PositionsMetaData.POSITIONS_NAME_KEY);
    int loncol=c.getColumnIndex(listagpsdb.PositionsMetaData.POSITIONS_LONGITUDE_KEY);
    int lancol=c.getColumnIndex(listagpsdb.PositionsMetaData.POSITIONS_LATITUDE_KEY);


    if(c.moveToFirst()){
        do {
             nomelista.append(c.getString(nomecol));
             latitudinelista.append(c.getString(lancol));
             longitudinelista.append(c.getString(loncol));

        } while (c.moveToNext());

        }

    db.close(); 

}
}