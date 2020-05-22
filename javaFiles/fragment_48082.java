public View getView(int position, View convertView, ViewGroup parent) {

    if (null == convertView) {
        LinearLayout view = (LinearLayout) LinearLayout.inflate(this.context, 
            R.layout.message, null);
        Log.d("SeenDroid", String.format("Get view %d", position));
        TextView title = new TextView(view.getContext());
        title.setText(this.items.get(position).getTitle());
        view.addView(title);
        return view;
    } else {
        LinearLayout view = (LinearLayout) convertView;
        TextView title = (TextView) view.getChildAt(0);
        title.setText(this.items.get(position).getTitle());
        return convertView;
    }
}