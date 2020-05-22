public class CustomAdapterextends BaseAdapter {

Context context;

protected List<Concert> listConcert;
LayoutInflater inflater;

public ListCarsAdapter(Context context, List<Concert> listConcert) {
    this.listConcert= listConcert;
    this.inflater = LayoutInflater.from(context);
    this.context = context;
}

public int getCount() {
    return listConcert.size();
}

public Concert getItem(int position) {
    return listConcert.get(position);
}

public View getView(int position, View convertView, ViewGroup parent) {
    ViewHolder holder;
    if (convertView == null) {

        holder = new ViewHolder();
        convertView = this.inflater.inflate(R.layout.concert_row,parent, false);

        holder.concertDayName = (TextView) convertView
                .findViewById(R.id.concert_day_name);
        holder.concertDayNumber= (TextView) convertView
                .findViewById(R.id.concert_day_number);
        holder.concertMonthName = (TextView) convertView
                .findViewById(R.id.concert_month_name);
        holder.concertOnSaleNow = (TextView) convertView
                .findViewById(R.id.concert_on_sale_now);
        holder.concertPlaceName = (TextView) convertView
                .findViewById(R.id.concert_place_name);

        convertView.setTag(holder);
    } else {
        holder = (ViewHolder) convertView.getTag();
    }

    Concert concert = listConcert.get(position);
    holder.concertDayName .setText(concert.getDayName());
    holder.concertDayNumber.setText(concert.getDayNumber());
    //etc.
    return convertView;
}

private class ViewHolder {
    TextView concertDayName;
    TextView concertDayNumber;
    Textview concertMonthName;
    Textview concertOnSaleNow;
    Textview concertPlaceName;
}

}