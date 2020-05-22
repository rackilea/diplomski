// adapter class
private boolean setBlueBackground = false;

public View getView(int position, View convertView, ViewGroup parent) {
    TextView textView;

    if (convertView == null) {
        // if it's not recycled, initialize some attributes
        textView = new TextView(mContext);
        textView.setGravity(Gravity.CENTER);
        textView.setLayoutParams(new GridView.LayoutParams(100, 100));

    } else {
        textView = (TextView) convertView;
    }

    if(setBlueBackground)
        textView.setBackgroundColor(Color.BLUE);
    else 
        textView.setBackgroundColor(Color.RED);

    textView.setText("" + position);
    return textView;
}

public void setBlueBg(boolean blue) {
    setBlueBackground = blue;
    notifyDataSetChanged();
}