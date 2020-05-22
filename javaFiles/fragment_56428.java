public class Admin extends AppCompatActivity  {

Spinner spinner_event;
Spinner spinner_activity;
Spinner spinner_wallpaper;
ArrayAdapter<CharSequence> adapter_wallpaper;
ArrayAdapter<CharSequence> adapter_event;
ArrayAdapter<CharSequence> adapter_activity;
Button startButton;
String textActivity;


@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    setContentView(R.layout.content_admin);


    spinner_event = (Spinner)findViewById(R.id.spinner_event);
    adapter_event = ArrayAdapter.createFromResource(this, R.array.events,android.R.layout.simple_spinner_dropdown_item);
    spinner_event.setAdapter(adapter_event);


    spinner_activity = (Spinner)findViewById(R.id.spinner_activity);
    adapter_activity = ArrayAdapter.createFromResource(this, R.array.activity,android.R.layout.simple_spinner_dropdown_item);
    spinner_activity.setAdapter(adapter_activity);


    spinner_wallpaper = (Spinner)findViewById(R.id.spinner_wallpaper);
    adapter_wallpaper = ArrayAdapter.createFromResource(this, R.array.wallpapers,android.R.layout.simple_spinner_dropdown_item);
    spinner_wallpaper.setAdapter(adapter_wallpaper);

    startButton = (Button)findViewById(R.id.startButton);

    }


public void jumpTo(View i)
{
textActivity = spinner_activity.getSelectedItem().toString();
if(textActivity.equals("Entree"){
                Intent i = new Intent(this, BadgeEntree.class);
                startActivity(i);
            }
            else
            {
            Log.d("Else","Wrong");
            }
}


}