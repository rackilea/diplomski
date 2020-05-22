public class WeatherLocationAdapter extends BaseAdapter{
private List <WeatherLocation> mLocations;
private Context mContext;
private int rowForLocationToInflate;
private LayoutInflater inflater;
private SettingsManager mSettingsMananger;

public WeatherLocationAdapter(List<WeatherLocation> mLocations, Context mContext, int rowForLocationToInflate) {
    this.mLocations = mLocations;
    this.mContext = mContext;
    this.rowForLocationToInflate = rowForLocationToInflate;
    inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    // to grab the saved zipcode (selected zipcode)
    mSettingsMananger = new SettingsManager(mContext);
}

private void addLocation(WeatherLocation newLocation){
    mLocations.add(newLocation);
}

@Override
public int getCount() {
    return mLocations.size();
}

@Override
public WeatherLocation getItem(int position) {
    return mLocations.get(position);
}

@Override
public long getItemId(int position) {
    return 0;
}

@Override
public View getView(int position, View convertView, ViewGroup parent) {
        //TODO build a viewholder

        // Inflate up
        View rowView = inflater.inflate(rowForLocationToInflate, parent, false);

        // Link up
        TextView tvZipcode = (TextView) rowView.findViewById(R.id.tvZipCode);
        TextView tvCity = (TextView) rowView.findViewById(R.id.tvCity);
        TextView tvTemp = (TextView) rowView.findViewById(R.id.tvDegree);

        // we will do logic here to pick the image
        TextView tvDesc = (TextView) rowView.findViewById(R.id.tvDesc);
        TextView tvTime = (TextView) rowView.findViewById(R.id.tvTimeStamp);
        ImageView ivWeather  =  (ImageView) rowView.findViewById(R.id.ivWeather);
        TextView tvSelected = (TextView) rowView.findViewById(R.id.tvCurrentlySelected);

        tvZipcode.setText(mLocations.get(position).getZipcode());
        tvCity.setText(mLocations.get(position).getCity());
        tvTemp.setText(String.valueOf(mLocations.get(position).getTemperature()));
        tvDesc.setText(mLocations.get(position).getDesc());

        // whats currently selected.
        if(mSettingsMananger.getZipCode().equals(mLocations.get(position).getZipcode())){
            tvSelected.setText("Currently Selected");
        }

        // Format the saved time.
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(mLocations.get(position).getTime_stamp());
        String time = checkForMilitaryTime(cal.getTime().getHours(), cal.getTime().getMinutes());
        tvTime.setText(time);

        // Decide what image to display - based off the description we got back.
        String desc = mLocations.get(position).getDesc();
        if(desc.equals("sky is clear")){
            ivWeather.setImageDrawable(mContext.getResources().getDrawable(R.drawable.ic_action_sun));
        }
        else if(desc.equals("few clouds")){
            ivWeather.setImageDrawable(mContext.getResources().getDrawable(R.drawable.ic_action_cloudy));
        }
        else if(desc.equals("broken clouds")){
            ivWeather.setImageDrawable(mContext.getResources().getDrawable(R.drawable.ic_action_cloudy));
        }
        else if(desc.equals("light intensity shower rain")){
            ivWeather.setImageDrawable(mContext.getResources().getDrawable(R.drawable.ic_action_rain));
        }



        return rowView;
}