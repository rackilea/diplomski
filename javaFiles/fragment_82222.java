public class OutagesAdapter extends ArrayAdapter<Outages>
{
    private List<Outages> listOfOutagesObjects;

    public InitialGetDataActivityAdapter(List<Outages> listOfOutagesObjects)
    {
        super(context, R.layout.single_row, listOfOutagesObjects);
        this.listOfOutagesObjects = listOfOutagesObjects;
    }

    @Override
    public int getCount() {
        return listOfOutagesObjects.size();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        Outages outagesObject = listOfParseObjects.get(position);
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(R.layout.single_row, parent, false);

        TextView tv_outagnumber = (TextView) rowView.findViewById(R.id.tv_outagnumber);
        TextView tv_impact = (TextView) rowView.findViewById(R.id.tv_impact);
        TextView tv_status = (TextView) rowView.findViewById(R.id.tv_status);
        TextView tv_timestamp = (TextView) rowView.findViewById(R.id.tv_timestamp);

        tv_outagnumber.setText(outagesObject.outagnumber);
        tv_impact.setText(outagesObject.impact);
        tv_status.setText(outagesObject.status);
        tv_timestamp.setText(outagesObject.timestamp);

        return rowView;
    }
}