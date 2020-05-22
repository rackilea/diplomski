public class MyActivity extends Activity {
    private EditText streetField;
    private EditText nameField;

    protected onCreate( Bundle savedBundle ) {
       streetField = findViewById( R.id.streetField );
       nameField = findViewVById( R.id.nameField );

       someButton.setOnClickListener( new View.OnClickListener() {
           public void onClick( View view ) {
               Person person = new Person();
               person.setName( nameField.getText().toString() );
               person.setStreet( streetField.getText().toString() );
           }
       });
    }
}