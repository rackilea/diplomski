public class CustomAdapter extends ArrayAdapter<String>{
private final Context context;
private final String[] values;


public CustomAdapter(Context context, String[] values) {
    super(context,R.layout.list_item,values);
    this.context = context;
    this.values = values;

}

@Override
public View getView(int position, View view, ViewGroup parent) {
    LayoutInflater inflater = LayoutInflater.from(context);
   View rview = inflater.inflate(R.layout.list_item,null);
    TextView txt = (TextView)rview.findViewById(R.id.instView);
    txt.setText(values[position]);
    AssetManager mgr = context.getAssets();
    Typeface tf = Typeface.createFromAsset(mgr,"fonts/RalewayRegular.ttf");
    txt.setTypeface(tf);
    return rview;
}


}