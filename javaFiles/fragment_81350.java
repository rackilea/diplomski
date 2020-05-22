@Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.custome_list, parent, false);
        }
        MediaFileInfo item = (MediaFileInfo) getItem(position);
        TextView text1 = (TextView) convertView.findViewById(R.id.textView);
        text1.setText(item.getTitle());
        TextView text2 = (TextView) convertView.findViewById(R.id.textView2);
        text2.setText(item.getArtist());


        return convertView;
    }