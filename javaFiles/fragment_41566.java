import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Cursor c;
        DatabaseHelper db = new DatabaseHelper(this);

        c = db.getReadableDatabase().rawQuery("SELECT * FROM items ORDER BY code", null);
        Log.d("TAG", "c count" +c.getCount());
        if(c.moveToFirst()){
            String code= c.getString(1);
            String item= c.getString(2);
            String info= c.getString(3);
            Log.d("TAG", "c1: " +code+ " c2: " +item+ " c3: " +info);
        }
    }
}