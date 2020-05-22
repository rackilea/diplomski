import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by amintavassolian on 15-06-05.
 */
public class ViewActivity extends Activity {

    MyDbHelper mHelper;
    SQLiteDatabase mDb;
    Cursor mCursor;
    private ListView mList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
        mHelper = new MyDbHelper(this);
        mList = (ListView)findViewById(R.id.list);
        mDb = mHelper.getWritableDatabase();
        String[] columns = new String[] {"_id", MyDbHelper.COL_NAME, MyDbHelper.COL_EMAIL, MyDbHelper.COL_TEXT, MyDbHelper.COL_DATE};
        mCursor = mDb.query(MyDbHelper.TABLE_NAME, columns, null, null, null, null, null, null);
        String[] headers = new String[] {MyDbHelper.COL_NAME,  MyDbHelper.COL_EMAIL, MyDbHelper.COL_TEXT, MyDbHelper.COL_DATE};
        List<String> itemsList = new ArrayList<String>();
        itemsList.add( MyDbHelper.COL_NAME );
        itemsList.add(MyDbHelper.COL_EMAIL) ;
        itemsList.add ( MyDbHelper.COL_TEXT ) ;
        itemsList.add ( MyDbHelper.COL_DATE ) ;
        ArrayAdapter<String> adapter = new ArrayAdapter<String>( this, android.R.layout.simple_list_item_1, itemsList ) ;
        mList.setAdapter(adapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_view, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}