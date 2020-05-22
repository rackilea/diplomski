public class MainActivity extends Activity implements OnClickListener{

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    Button btn = (Button)findViewById(R.id.mybtn);
    btn.setOnClickListener(this);

}



public void showDialog(){

    AlertDialog.Builder builder = new AlertDialog.Builder(new ContextThemeWrapper(this, R.style.AlertDialogCustom));
    builder.setMessage("Test")

           .setPositiveButton("YES", new DialogInterface.OnClickListener() {
               public void onClick(DialogInterface dialog, int id) {
                   // FIRE ZE MISSILES!
               }
           })
           .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
               public void onClick(DialogInterface dialog, int id) {
                   // User cancelled the dialog
               }
           });

   builder.show();
    // Create the AlertDialog object and return it

}
@Override
public void onClick(View v) {
    switch (v.getId()) {
    case R.id.mybtn:
        showDialog();   
        break;

    default:
        break;
    }   
}