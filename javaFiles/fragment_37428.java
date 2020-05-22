public class HeadZoom extends MainActivity implements AdapterView.OnItemSelectedListener{

private Spinner hairSpinner;
private Spinner hairColor;
private String type;
private String color;
private ImageView imageView;
private List<String> hairTypeArray = new ArrayList<String>();
private List<String> hairColorArray = new ArrayList<String>();

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.head_zoom);
    Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);

    imageView = (ImageView) findViewById(R.id.head);
    type="Bald";

    hairSpinner = (Spinner) findViewById(R.id.hairSpinner);
    hairSpinner.setOnItemSelectedListener(this);
    hairTypeArray.add("Bald");
    hairTypeArray.add("Female Short");
    hairTypeArray.add("Female Medium");
      (...)
    ArrayAdapter<String> hairTypeAdapter = new ArrayAdapter<String>(this,
            android.R.layout.simple_spinner_item, hairTypeArray);
    hairTypeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    hairSpinner.setAdapter(hairTypeAdapter);

    color = "Black";

    hairColor = (Spinner) findViewById(R.id.hairColor);
    hairColor.setOnItemSelectedListener(this);
    hairColorArray.add("Black");
    hairColorArray.add("Blonde");
    hairColorArray.add("Blue");
      (...)
    ArrayAdapter<String> hairColorAdapter = new ArrayAdapter<String>(this,
            android.R.layout.simple_spinner_item, hairColorArray);
    hairColorAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    hairColor.setAdapter(hairColorAdapter);
}

public void onItemSelected(AdapterView<?> parent, View view, int position, long id){
    if(parent.getId()==hairSpinner.getId())
        type = hairTypeArray.get(position);
    else
        color = hairColorArray.get(position);

    switch(type){
        case "Bald":
            imageView.setImageResource((R.drawable.sw_head));
            break;
        case "Female Short":
            if(color.equals("Black"))
                imageView.setImageResource(R.drawable.fhair_short_black);
            else if(color.equals("Blonde"))
                imageView.setImageResource(R.drawable.fhair_short_blonde);
            else if(color.equals("Blue"))
                imageView.setImageResource(R.drawable.fhair_short_blue);
            else if(color.equals("Brown"))
                (...)
                break;
        case "Female Medium":
            if(color.equals("Black"))
                imageView.setImageResource(R.drawable.fhair_med_black);
            else if(color.equals("Blonde"))
                imageView.setImageResource(R.drawable.fhair_med_blonde);
            else if(color.equals("Blue"))
                imageView.setImageResource(R.drawable.fhair_med_blue);
            else if(color.equals("Brown"))
                (...)
                break;
        case "Female Long":
               (...)
        default:
            break;
    }
}

public void onNothingSelected(AdapterView<?> parent){

}