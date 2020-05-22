//java for my class 
import java.util.ArrayList;
import java.util.List;

import android.app.ListActivity;
import android.database.Cursor;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class editpage extends ListActivity {
    int editCount;
    private dbadapter mydbhelper;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.edit_list);
        mydbhelper = new dbadapter(this);
        mydbhelper.open();
        fillData();
    }



    private void fillData() {


        Cursor e = mydbhelper.getUserWord();
            startManagingCursor(e);

     // Create an array to specify the fields we want to display in the list (TITLE,DATE,NUMBER)
        String[] from = new String[] {dbadapter.KEY_USERWORD,};

        // an array of the views that we want to bind those fields to (in this case text1,text2,text3)
        int[] to = new int[] {R.id.textType,};

        // Now create a simple cursor adapter and set it to display
       SimpleCursorAdapter editadapter = 
       new SimpleCursorAdapter(this, R.layout.edit_row, e, from, to);
       ListView list = getListView();
       View footer = getLayoutInflater().inflate(R.layout.footer_layout, list, false);
       list.addFooterView(footer);
       setListAdapter(editadapter);
       editCount = e.getCount();
        }

        public void onClick(View footer){
            final MediaPlayer editClickSound = MediaPlayer.create(this, R.raw.button50);
                editClickSound.start();
                    };


@Override
protected void onListItemClick(ListView list, View v, int position, long id)
{
    super.onListItemClick(list, v, position, id);
    //final Intent intent = new Intent(this, title.class);
    //startActivityForResult(intent, position);
    }