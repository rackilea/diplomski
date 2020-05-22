public class SongAdapter extends BaseAdapter {

Context context;
ArrayList<Mp3Model> mp3Models;
LayoutInflater inflater;
Typeface captureFont;

public SongAdapter(Context context, ArrayList<Mp3Model> mp3Models) {
    this.context = context;
    this.mp3Models = mp3Models;
    inflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    captureFont = Typeface.createFromAsset(this.context.getAssets(), "fonts/Montserrat.ttf");
}

@Override
public int getCount() {
    return mp3Models.size();
}

@Override
public Object getItem(int position) {
    return position;
}

@Override
public long getItemId(int position) {
    return position;
}

public class ViewHolder {
    TextView songName;
}

@Override
public View getView(int position, View convertView, ViewGroup parent) {
    ViewHolder vh;
    if (convertView == null) {
        vh = new ViewHolder();
        convertView = inflater.inflate(R.layout.song_row, parent, false);
        vh.songName = (TextView) convertView.findViewById(R.id.songName);
        convertView.setTag(vh);
    } else {
        vh = (ViewHolder) convertView.getTag();
    }
    vh.songName.setText(mp3Models.get(position).getTitle());
    vh.songName.setTypeface(captureFont);
    vh.songName.setPadding(10, 10, 10, 10);
    vh.songName.setTextColor(Color.WHITE);
    vh.songName.setBackgroundColor(Color.parseColor("#333333"));
    vh.songName.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18);
    return convertView;
}
}