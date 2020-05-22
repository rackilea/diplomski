import android.app.Activity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class DatabaseExample extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        //Setup edit fields
        EditText firstEdit = (EditText)findViewById(R.id.firstEdit);
        EditText middleEdit = (EditText)findViewById(R.id.middleEdit);
        EditText lastEdit = (EditText)findViewById(R.id.lastEdit);
        EditText birthEdit = (EditText)findViewById(R.id.birthEdit);


        //Get the text and store in variables
        String firstName = firstEdit.getText().toString();
        String middleName = middleEdit.getText().toString();
        String lastName = lastEdit.getText().toString();
        String birthDate = birthEdit.getText().toString();

        //setup the text fields
        TextView firstTable = (TextView)findViewById(R.id.firstTable);
        TextView middleTable = (TextView)findViewById(R.id.middleTable);
        TextView birthTable = (TextView)findViewById(R.id.birthTable);

        //change the text fields
        firstTable.setText(firstName);
        middleTable.setText(middleName);
        birthTable.setText(birthDate);


    }
}