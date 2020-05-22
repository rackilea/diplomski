private class CustomTextAndImageAdapter extends ArrayAdapter<Weather>
{
    private LayoutInflater inflater;

    public CustomTextAndImageAdapter(Context context, Activity activity, int resource, List<Weather> items)
    {
        super(context, resource, items);
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public View getView(int position, View view, ViewGroup parent)
    {
        View rowView= inflater.inflate(R.layout.itemlistrow, null, false);

        TextView timeTextView = (TextView)rowView.findViewById(R.id.time);
        timeTextView.setText(getItem(position).getTime());

        ImageView iconImageView = (ImageView) rowView.findViewById(R.id.weatherIcon);
        iconImageView.setImageBitmap(getItem(position).getWeatherIcon());

        ........

        return rowView;
    }
}