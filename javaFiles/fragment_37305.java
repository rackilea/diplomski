public class SpinnerCustomizationActivity extends Activity {

String[] spinnerValues = { "Blur", "NFS", "Burnout","GTA IV", "Racing", }; 
String[] spinnerSubs = { "Ultimate Game", "Need for Speed", "Ulimate   Racing", "Rockstar Games", "Thunder Bolt" };
@Override
public void onCreate(Bundle savedInstanceState) {      

super.onCreate(savedInstanceState); 
setContentView(R.layout.main);
Spinner mySpinner = (Spinner) findViewById(R.id.spinner_show);     
mySpinner.setAdapter(new MyAdapter(this, R.layout.custom_spinner,    spinnerValues)); }

public class MyAdapter extends ArrayAdapter<String> {
public MyAdapter(Context ctx, int txtViewResourceId, String[] objects)
{ 
  super(ctx, txtViewResourceId, objects); }
 @Override 
 public View getDropDownView(int position, View cnvtView, ViewGroup prnt) { return getCustomView(position, cnvtView, prnt); }

  @Override
  public View getView(int pos, View cnvtView, ViewGroup prnt)

 { 

  return getCustomView(pos, cnvtView, prnt);
 }
  public View getCustomView(int position, View convertView, ViewGroup parent)       
  { 

 LayoutInflater inflater = getLayoutInflater();
 View mySpinner = inflater.inflate(R.layout.custom_spinner, parent, false);                 
 TextView main_text = (TextView)mySpinner.findViewById(R.id.text_main_seen); 
 main_text.setText(spinnerValues[position]);
 TextView subSpinner = (TextView)mySpinner.findViewById(R.id.sub_text_seen); 

 subSpinner.setText(spinnerSubs[position]);
 return mySpinner; }
 } 
 }