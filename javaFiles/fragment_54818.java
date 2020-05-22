public class AppActivity extends Activity {
Button button;
Context context = this;

private final CharSequence[] TRAVELS ="Nirmala travels","RR Tours and Travels","Surabhii Travels"};
String numbertodial;
String phonenumberNT ="08242497051";
String phonenumberRR ="08244280999";
String phonenumberST ="08242212111";

@Override
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main);

button = (Button) findViewById(R.id.button);
button.setOnClickListener(new OnClickListener() {
    public void onClick(View v) {
    Dialog dialog = null;
    AlertDialog.Builder builder = null;
    builder = new AlertDialog.Builder(context);

    String travels = getString(R.string.app_name);
    builder.setTitle(travels);
    builder.setSingleChoiceItems(TRAVELS, 3,
    new DialogInterface.OnClickListener() {
    public void onClick(DialogInterface dialog, int item) {

    CharSequence s = (TRAVELS[item]);


    //THIS CAN BE IMPROVED. I DONT HAVE THE TIME BUT IT SHOULD STILL WORK. 
    if (s.equals("Nirmala travels")){numbertodial =phonenumberNT; }
    if (s.equals("RR Tours and Travels")){numbertodial=phonenumberRR; }
    if (s.equals("Surabhii Travels")){numbertodial=phonenumberST ;}
    Intent callIntent = new Intent(Intent.ACTION_DIAL);
    callIntent.setData(Uri.parse("tel:"+numbertodial ));
    startActivity(callIntent);

    dialog.dismiss();
    }});
    dialog = builder.create();
    dialog.show();
    return;

        }
    });
//REMOVE addListenerOnButton(); and it's method
    }