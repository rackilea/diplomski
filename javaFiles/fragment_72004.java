import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by amintavassolian on 15-06-05.
 */
public class AddActivity2Activity extends Activity implements View.OnClickListener{

    EditText mText;
    EditText mText1;
    EditText mText2;
    Button mAdd;

    MyDbHelper mHelper;
    SQLiteDatabase mDb;
    Cursor mCursor;
    SimpleCursorAdapter mAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_activity2);

        mText = (EditText)findViewById(R.id.name);
        mText1 = (EditText)findViewById(R.id.email);
        mText2 = (EditText)findViewById(R.id.comment);
        mAdd = (Button)findViewById(R.id.add);
        mAdd.setOnClickListener(this);


        mHelper = new MyDbHelper(this);
        mDb = mHelper.getWritableDatabase();
    }

    @Override
    public void onPause() {
        super.onPause();
        mDb.close();
    }

    public void onClick(View v) {
        ContentValues cv = new ContentValues();
        cv.put(MyDbHelper.COL_NAME, mText.getText().toString());
        cv.put(MyDbHelper.COL_EMAIL, mText1.getText().toString());
        cv.put(MyDbHelper.COL_TEXT, mText2.getText().toString());
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        cv.put(MyDbHelper.COL_DATE, dateFormat.format(new Date())); //Insert 'now' as the date
        mDb.insert(MyDbHelper.TABLE_NAME, null, cv);

        mText.setText(null);
        mText1.setText(null);
        mText2.setText(null);
        Toast.makeText(getApplicationContext(), "Record Created Successfully", Toast.LENGTH_LONG).show();
    }

    public void viewButtonClicked(View v){
        Intent intent = new Intent(AddActivity2Activity.this, ViewActivity.class);
        startActivity(intent);
    }
}