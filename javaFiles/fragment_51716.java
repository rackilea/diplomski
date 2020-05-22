public class RezeptArrayAdapter extends ArrayAdapter<String> {

    public final Context context;
    public final String[] values;
    final DBHandler_Rezepte db_Rzpt;
    //TYPEFACE///////////
    Typeface tf;


    public RezeptArrayAdapter(Context context, String[] values) {
        super(context, R.layout.list_rezepte, values);
        this.context = context;
        this.values = values;

        // Do "static/reusable" stuff here
        // DatenBank Abfrage Angepasst auf den Array "context" View
        db_Rzpt = new DBHandler_Rezepte(context);
        //TYPEFACE///////////
        tf = Typeface.createFromAsset(context.getAssets(), "fonts/OFLGoudyStMTT.ttf");
    }

    // will be called quite often! Make it fast as possible!
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        //Einzelabfrage der Datenbank Ratings damit Sie weiter unten verarbeitet werden können
        ConDB_Rezepte data = db_Rzpt.getConDB_Rezepte(position);

        // To not do too much at once this tip for later: Use the ViewHolder pattern
        View rowView = inflater.inflate(R.layout.list_rezepte, parent, false);
        TextView textView = (TextView) rowView.findViewById(R.id.label);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.logo);
        RatingBar ratingbar1 = (RatingBar) rowView.findViewById(R.id.ratingBar1);

        //stellt ein das man die Ratingbar nicht clicken kann, somit bleibt die Steuerung erhalten. Sonst ist die Liste nicht mehr clickbar
        ratingbar1.setIsIndicator(true);

        textView.setText(values[position]);

        textView.setTypeface(tf);


        // Change icon based on name
        String pos = values[position];

        // data should contain the information which icon should be shown!
        //int KuchenIcon = R.drawable.ic_kuchen;
        //int MuffinIcon = R.drawable.ic_muffin;
        //int PlaetzchenIcon = R.drawable.ic_plaetzchen;
        //int ApfelkandiertIcon = R.drawable.ic_apfelkandiert;
        //int OthersIcon = R.drawable.ic_others;

        // apply values/data to the view
        imageView.setImageResource(data.getIcon());
        ratingbar1.setRating(data.getrating());

        return rowView;
    }

}