public class MobileArrayAdapter extends ArrayAdapter<String>
{
    private final Context context;
    private ArrayList<String> contactNamesList;
    View rowView;
    ImageView imageview;

    public MobileArrayAdapter(Context context, ArrayList<String> contactNamesList) {
        super(context, R.layout.yourimagetextlayout, contactNamesList);
        this.context = context;
        this.contactNamesList = new ArrayList<String>();
        this.contactNamesList.addAll(contactNamesList);
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        rowView = inflater.inflate(R.layout.yourimagetextlayout, parent, false);
        TextView textView = (TextView) rowView.findViewById(R.id.label);
        imageview = (ImageView) rowView.findViewById(R.id.logo);
        String findname=contactNamesList.get(position);
        textView.setText(contactNamesList.get(position));
        imageview.setImageBitmap(ur image phto path);
        return rowView;
    }

}