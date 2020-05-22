package my.package;

import android.app.Activity;


public class MyActivity extends Activity {


private DBAdapter mDb;

private ListView mListView;
private Cursor mCursor;   



@Override
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.groups_list);       

    mDb = new DBAdapter(this);
    mDb.open();       

    populateListView();
}    

@Override
public void onDestroy() {
    super.onDestroy();

    if(mCursor != null)
        mCursor.close();
    mCursor = null;

    if(mDb != null)
        mDb.close();        
    mDb = null;       
}    


private void populateListView(){        

    if(mCursor!=null)  //close the old one first
        mCursor.close();
    mCursor = mDb.getSomeDataCursor();                

    MainAdapter adapter = new MainAdapter(this, R.layout.groups_list_item, mCursor, false);        
    mListView.setAdapter(adapter);
}    


 private class MainAdapter extends ResourceCursorAdapter{

    private int mLayout;
    private int mColumnIndexGroup;

    public MainAdapter(Context pContext, int pLayout, Cursor pCursor, boolean pAutoRequery) {
        super(pContext, pLayout, pCursor, pAutoRequery);

        mLayout = pLayout;
        mColumnIndexGroup = (pCursor.getColumnIndex(DBAdapter.COL_NAME)); 
    }        

    @Override
    public View newView(Context pContext, Cursor pCursor, ViewGroup pParent) {
        LayoutInflater li = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        return li.inflate(mLayout, pParent, false);
    }        

    @Override
    public void bindView(View pView, Context pContext, Cursor pCursor) {           
        TextView tvGroup = (TextView)pView.findViewById(R.id.groupsListTVGroup);
        tvGroup.setText(pCursor.getString(mColumnIndexGroup));

        //Image stuff - an example
        if(pCursor.getInt(pCursor.getColumnIndex(SOMETHING)) == SOME_VAL){
            ImageView img = (ImageView) pView.findViewById(R.id.myImage);
            img.setImageResource(R.drawable.myImage)
        }
   }     

}